package com.mockmvc.controller;

import com.mockmvc.entity.Student;
import com.mockmvc.serviceImpl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentServiceImpl studentService;

    @Test
    void getStudent_data() throws Exception {
        when(studentService.getStudent_data())
                .thenReturn(
                        Arrays.asList(new Student(0, "St1", "St2", 35),
                                new Student(1, "St1", "St2", 35))
                );
        mockMvc.perform(MockMvcRequestBuilders.get("/students")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("[{\"id\":0,\"firstName\":\"St1\",\"lastName\":\"St2\",\"age\":35},{\"id\":1,\"firstName\":\"St1\",\"lastName\":\"St2\",\"age\":35}]"))
                .andReturn();

    }


}