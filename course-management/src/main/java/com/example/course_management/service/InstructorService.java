package com.example.course_management.service;

import com.example.course_management.dto.InstructorCreateRequest;
import com.example.course_management.model.Instructor;
import com.example.course_management.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // Lấy Instructor theo ID, trả về Optional
    public Optional<Instructor> findInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    // Lấy toàn bộ danh sách Instructor
    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    // Tạo mới Instructor từ DTO
    public Instructor createInstructor(InstructorCreateRequest req) {
        // Tạo đối tượng Instructor mới từ thông tin request (không cần truyền ID)
        Instructor instructor = new Instructor(req.getName(), req.getEmail());

        // Jpa tự hiểu không có ID thì sẽ là tạo mới (INSERT)
        return instructorRepository.save(instructor);
    }
}