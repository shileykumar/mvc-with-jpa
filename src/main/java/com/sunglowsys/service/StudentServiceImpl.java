package com.sunglowsys.service;

import com.sunglowsys.domain.Student;
import com.sunglowsys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()){
            student = optional.get();
        }
        else {
            throw new RuntimeException("Student not found for id:"+id);
        }
        return student;
    }

    @Override
    public Student update(Student student, Long id) {
        Student student1 = studentRepository.findById(id).get();
        student1.setFirstName(student.getFirstName());
        return studentRepository.save(student1);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
