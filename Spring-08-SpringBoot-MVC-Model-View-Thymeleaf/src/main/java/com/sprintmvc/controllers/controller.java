package com.sprintmvc.controllers;

import com.sprintmvc.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class controller {

    @GetMapping("/welcome")
    public String homePage(Model model) {
        String name = "Ruslan";
        String subject = "Collection";
        model.addAttribute("name", name);
        model.addAttribute("subject", subject);
        model.addAttribute("studentID", Math.random());

        List<Integer> number = new ArrayList<>();
        number.add(4);
        number.add(5);
        number.add(6);
        model.addAttribute("number", number);

        LocalDate bd = LocalDate.now().minusYears(42);
        model.addAttribute("date", bd);

        Student st = new Student(1, "Ruslan", "Kasymov");

        model.addAttribute("student", st);
        return "student/welcome";
    }

    @GetMapping("/mentors")
    public String getMentors() {
        return "mentors/mentor";
    }
}
