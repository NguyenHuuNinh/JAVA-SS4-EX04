package com.example.course_management.service;

import com.example.course_management.dto.CourseCreateRequest;
import com.example.course_management.model.Course;
import com.example.course_management.model.Instructor;
import com.example.course_management.repository.CourseRepository;
import com.example.course_management.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    public Course createCourse(CourseCreateRequest req) {
        Instructor instructor = instructorRepository.findById(req.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Instructor"));
        Course course = new Course(req.getTitle(), req.getStatus(), instructor);
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, CourseCreateRequest req) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Course"));
        Instructor instructor = instructorRepository.findById(req.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Instructor"));

        course.setTitle(req.getTitle());
        course.setStatus(req.getStatus());
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }
}