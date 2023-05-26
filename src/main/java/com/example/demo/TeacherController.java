package com.example.demo;


import com.example.demo.exception.ElementAlreadyExistsException;
import com.example.demo.exception.ElementNotFoundExeption;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) throws ElementAlreadyExistsException {
        Teacher teacherSaved = teacherService.save(teacher);

        return new ResponseEntity<>(teacherSaved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> findById(@RequestParam int page,  @RequestParam int size) {
        List<Teacher> teachers = teacherService.findAll(page, size);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ElementNotFoundExeption {
        teacherService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher updated = teacherService.update(id, teacher);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
