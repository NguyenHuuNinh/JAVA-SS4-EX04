package com.example.course_management.service;

import com.example.course_management.dto.StudentCreateRequest;
import com.example.course_management.model.Student;
import com.example.course_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentCreateRequest req) {
        Student student = new Student();
        student.setName(req.getName());
        student.setEmail(req.getEmail());
        return studentRepository.save(student);
    }
}