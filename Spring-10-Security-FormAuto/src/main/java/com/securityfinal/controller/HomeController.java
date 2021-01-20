package com.securityfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String welcome() {
        return "index";
    }

    @GetMapping(value = {"/", "/login"})
    public String login(){
        return "Login";
    }
}
