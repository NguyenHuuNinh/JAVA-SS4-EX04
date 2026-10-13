package com.example.course_management.controller;

import com.example.course_management.dto.ApiResponse;
import com.example.course_management.dto.EnrollmentRequest;
import com.example.course_management.dto.StudentCreateRequest;
import com.example.course_management.service.StudentEnrollmentService;
import com.example.course_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired private StudentService studentService;
    @Autowired private StudentEnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createStudent(@RequestBody StudentCreateRequest req) {
        studentService.createStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Student Created Successfully", true, null));
    }

    @PostMapping("/enrollments")
    public ResponseEntity<ApiResponse<Void>> enrollStudent(@RequestBody EnrollmentRequest req) {
        enrollmentService.enrollStudent(req.getStudentId(), req.getCourseId());
        return ResponseEntity.ok(new ApiResponse<>("Student Enrolled Successfully", true, null));
    }
}