package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentors")
public class MentorController {

    @GetMapping("/show")
    public String showForm() {
        return "home";
    }
}
