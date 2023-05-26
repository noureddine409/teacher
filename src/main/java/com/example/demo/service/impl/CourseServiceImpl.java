package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    @Override
    public List<Course> findAll(int page, int size) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Course update(Long id, Course course) {
        return null;
    }
}
