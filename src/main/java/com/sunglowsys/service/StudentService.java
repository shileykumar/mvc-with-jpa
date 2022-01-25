package com.sunglowsys.service;

import com.sunglowsys.domain.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> findAll();

    Student findById(Long id);

    Student update(Student student, Long id);

    void  delete(Long id);
}
