package com.example.course_management.repository;

import com.example.course_management.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    // Không cần viết code bên trong, JpaRepository đã lo hết các hàm CRUD cơ bản
}