package com.example.springbootjpatutorial.repository;

import com.example.springbootjpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("StudentRepository")
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String firstName);

    //List<Student> findBySecondNameNotNull(String secondName); ????????????????

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndSecondName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailAddress );

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailAddress);

    //Native
    @Query(
            value = "Select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailAddress);

    //Native Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailAddress",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeParam(@Param("emailAddress") String emailAddress);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmailAddress(String firstName, String emailId);



}
