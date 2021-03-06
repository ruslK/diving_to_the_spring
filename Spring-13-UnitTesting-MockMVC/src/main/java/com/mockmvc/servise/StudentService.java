package com.mockmvc.servise;

import com.mockmvc.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> getStudent_data();
}
