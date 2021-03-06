package com.mockmvc.controller;

import com.mockmvc.entity.Student;
import com.mockmvc.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

//    public StudentController(StudentServiceImpl studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        System.out.println(studentService.getStudent_data());
        return studentService.getStudent_data();
    }
}
