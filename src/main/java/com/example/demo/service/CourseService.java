package com.example.demo.service;

import com.example.demo.model.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    Course findById(Long id);

    List<Course> findAll(int page, int size);

    void delete(Long id);

    Course update(Long id, Course course);
}
