package com.mockmvc.serviceImpl;

import com.mockmvc.entity.Student;
import com.mockmvc.repository.StudentRepository;
import com.mockmvc.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudent_data() {
        return studentRepository.findAll();
    }



}
