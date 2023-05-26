package com.example.demo.service;

import com.example.demo.model.Teacher;

import java.util.List;

public interface TeacherService {


    Teacher save(Teacher teacher);

    Teacher findById(Long id);

    List<Teacher> findAll(int page, int size);

    void delete(Long id);

    Teacher update(Long id, Teacher teacher);

}
