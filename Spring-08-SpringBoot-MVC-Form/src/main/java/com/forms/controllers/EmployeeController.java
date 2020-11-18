package com.forms.controllers;

import com.forms.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    List<Employee> listEmployee = new ArrayList<>();

    @GetMapping("/registration")
    public String registration(Model model) {
        List<String> states = new ArrayList<>();
        states.add("Washington");
        states.add("Florida");
        states.add("Georgia");
        states.add("Texas");
        states.add("New Mexico");
        states.add("Arizona");
        Collections.sort(states);
        model.addAttribute("states", states);
        model.addAttribute("newEmployee", new Employee());
        return "/employee/employee-register";
    }

    @PostMapping("/employees")
    public String employeesTable(@ModelAttribute("newEmployee") Employee newEmployee, Model model2) {
        listEmployee.add(newEmployee);
        model2.addAttribute("listEmployee", listEmployee);
        return "/employee/employees-table";
    }

    @GetMapping("/employees")
    public String getEmployeesTable(Model model2) {
        model2.addAttribute("listEmployee", listEmployee);
        return "/employee/employees-table";
    }
}
