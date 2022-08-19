package com.example.springbootjpatutorial.repository;

import com.example.springbootjpatutorial.entity.Course;
import com.example.springbootjpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course =
                Course.builder()
                        .title("DSA")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.google.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }
}