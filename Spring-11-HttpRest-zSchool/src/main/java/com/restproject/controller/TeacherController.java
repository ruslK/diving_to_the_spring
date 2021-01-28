package com.restproject.controller;

import com.restproject.entity.Address;
import com.restproject.entity.Teacher;
import com.restproject.repository.TeacherRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllTeacher() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Version", "1");
        headers.set("Method", "Get all Teachers");
        return ResponseEntity.ok().headers(headers)
                .body(teacherRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody() Teacher teacher) {
        System.out.println(teacher.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Version", "1");
        headers.set("Method", "Create teacher");
        teacherRepository.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers)
                .body(teacherRepository.findByUsername(teacher.getUsername()));
    }
}

