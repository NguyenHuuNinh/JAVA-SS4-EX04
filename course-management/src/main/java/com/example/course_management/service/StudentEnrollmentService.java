package com.example.course_management.service;

import com.example.course_management.model.Course;
import com.example.course_management.model.Student;
import com.example.course_management.model.StudentEnrollment;
import com.example.course_management.repository.CourseRepository;
import com.example.course_management.repository.StudentEnrollmentRepository;
import com.example.course_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollmentService {
    @Autowired private StudentRepository studentRepository;
    @Autowired private CourseRepository courseRepository;
    @Autowired private StudentEnrollmentRepository enrollmentRepository;

    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Student"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Course"));

        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);
    }
}