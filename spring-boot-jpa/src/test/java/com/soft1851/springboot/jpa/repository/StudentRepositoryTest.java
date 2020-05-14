package com.soft1851.springboot.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Resource
    private StudentRepository studentRepository;

    @Resource
    private ClazzRepository clazzRepository;

    @Resource
    private TeacherRepository teacherRepository;

    @Test
    void findByClazzId() {
        studentRepository.findByClazzId(1).forEach(System.out::println);
    }

    @Test
    void findClazzByIdEquals() {
        System.out.println(clazzRepository.findClazzByIdEquals(1));
    }

    @Test
    void findTeacherByIdEquals() {
        System.out.println(teacherRepository.findTeacherByIdEquals(1));
    }
}