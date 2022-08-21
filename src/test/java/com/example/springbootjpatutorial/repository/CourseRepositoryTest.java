package com.example.springbootjpatutorial.repository;

import com.example.springbootjpatutorial.entity.Course;
import com.example.springbootjpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

     @Test
    public void saveCourseWithTeacherObject() {

        Teacher teacher = Teacher.builder()
                .firstName("Ali")
                .lastName("Urgum")
                .build();

        Course course =
                Course.builder()
                        .title("Python")
                        .credit(6)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {

        Pageable firstPageableWithThreeRecords = PageRequest.of(0,3);

        Pageable secondPageableWithThreeRecords = PageRequest.of(0,2);

        List<Course> list = courseRepository.findAll(secondPageableWithThreeRecords).getContent();

        System.out.println("List : " + list);

    }
}