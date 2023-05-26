package com.example.demo.service.impl;

import com.example.demo.exception.ElementAlreadyExistsException;
import com.example.demo.exception.ElementNotFoundExeption;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {

        Optional<Teacher> teacherfound = teacherRepository.findById(teacher.getId());

        if(teacherfound.isPresent()) {
            throw new ElementAlreadyExistsException();
        }

        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return  teacherRepository.findAll(pageable).toList();
    }

    @Override
    public void delete(Long id) {

        Optional<Teacher> teacherfound = teacherRepository.findById(id);

        if(teacherfound.isEmpty()) {
            throw new ElementNotFoundExeption();
        }

        teacherRepository.deleteById(id);

    }

    @Override
    public Teacher update(Long id, Teacher teacher) {
        Optional<Teacher> teacherfound = teacherRepository.findById(teacher.getId());

        if(teacherfound.isEmpty()) {
            throw new ElementNotFoundExeption();
        }
        return teacherRepository.save(teacher);
    }
}
