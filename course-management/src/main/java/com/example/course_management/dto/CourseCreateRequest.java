package com.example.course_management.dto;
import com.example.course_management.model.CourseStatus;

public class CourseCreateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public CourseStatus getStatus() { return status; }
    public void setStatus(CourseStatus status) { this.status = status; }
    public Long getInstructorId() { return instructorId; }
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; }
}