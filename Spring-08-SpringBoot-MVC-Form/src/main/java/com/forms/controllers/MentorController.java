package com.forms.controllers;

import com.forms.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String showForm(Model model) {
        List<String> batchList = new ArrayList<>();
        batchList.add("Batch 1");
        batchList.add("Batch 2");
        batchList.add("Batch 3");
        batchList.add("Batch 4");
        batchList.add("Batch 5");

        model.addAttribute("batchList", batchList);
        model.addAttribute("mentor", new Mentor());
        return "/mentor/mentor";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor) {

        return "/mentor/confirm";
    }
}
