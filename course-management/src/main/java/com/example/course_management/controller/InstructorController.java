package com.example.course_management.controller;

import com.example.course_management.dto.ApiResponse;
import com.example.course_management.dto.InstructorCreateRequest;
import com.example.course_management.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createInstructor(@RequestBody InstructorCreateRequest req) {
        instructorService.createInstructor(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Instructor Created Successfully", true, null));
    }
}