package com.ticketsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getStartPoint() {
        return "index";
    }

    @GetMapping("/welcome")
    public String getWelcome() {
        return "welcome";
    }
}
