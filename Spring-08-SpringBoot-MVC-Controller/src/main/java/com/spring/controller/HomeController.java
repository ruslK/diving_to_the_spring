package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping()
    public String getRequestMapping() {
        return "home";
    }

    @GetMapping(value = "/test")
    public String getRequestMapping2() {
        return "home";
    }

    @PostMapping(value = "/test")
    public String getRequestMapping3() {
        return "home";
    }

    @GetMapping("/test/{data}")
    public String pathVariable(@PathVariable("data") String name) {
        System.out.println(name);
        return "home";
    }

    @GetMapping("/test/{data}/{data2}")
    public String pathVariable(@PathVariable("data") String name, @PathVariable("data2") String name2) {
        System.out.println(name);
        System.out.println(name2);
        return "home";
    }

    @GetMapping("test/course")
    public String requestParamEx(@RequestParam(value = "course", required = false, defaultValue = "Test") String data) {
        System.out.println(data);
        return "home";
    }
}
