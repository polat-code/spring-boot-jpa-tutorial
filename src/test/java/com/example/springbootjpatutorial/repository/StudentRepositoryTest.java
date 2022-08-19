package com.example.springbootjpatutorial.repository;

import com.example.springbootjpatutorial.entity.Guardian;
import com.example.springbootjpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    @Qualifier("StudentRepository")
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("ozgurhan@gmail.com")
                .firstName("Özgürhan")
                .secondName("Polat")
                //.guardianEmail("guardian@gmail.com")
                //.guardianMobile("05536596465")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Alian")
                .mobile("992992929292")
                .email("Alian01@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Özgürhaan")
                .secondName("Polat")
                .emailId("ozgurhanp@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Özgürhan");
        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> student = studentRepository.findByFirstNameContaining("Özgür");
        System.out.println("Students : " + student);

    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Alian");
        System.out.println("Students : " + students);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("ozgurhan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName= studentRepository.getStudentFirstNameByEmailAddress("ozgurhan@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public  void printgetStudentFirstNameByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("ozgurhan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeParam("ozgurhan@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printupdateStudentFirstNameByEmailAddress(){
        int number = studentRepository.updateStudentFirstNameByEmailAddress("Özgür","ozgurhan@gmail.com");

        System.out.println(number);
    }





}