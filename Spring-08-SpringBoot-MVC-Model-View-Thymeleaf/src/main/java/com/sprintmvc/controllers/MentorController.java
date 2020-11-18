package com.sprintmvc.controllers;

import com.sprintmvc.entities.Mentor;
import com.sprintmvc.enums.Gender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/list")
    public String showTable(Model model) {
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Steave", "Michle", 34, Gender.MALE));
        mentorList.add(new Mentor("Tom", "Jerry", 32, Gender.FEMALE));
        mentorList.add(new Mentor("Rahmon", "White", 39, Gender.MALE));
        mentorList.add(new Mentor("Ozodi", "Sharipova", 44, Gender.FEMALE));
        model.addAttribute("mentors", mentorList);
        return "mentors/mentor";
    }
}
