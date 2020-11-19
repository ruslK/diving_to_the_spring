package com.forms.controllers;

import com.forms.datagenerator.DataGenerator;
import com.forms.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("states", DataGenerator.mapOfUSStates);
        model.addAttribute("newEmployee", new Employee());
        return "/employee/employee-register";
    }

    @PostMapping("/employees")
    public String employeesTable(@ModelAttribute("newEmployee") Employee newEmployee, Model model2) {
        DataGenerator.listEmployee.add(newEmployee);
        model2.addAttribute("listEmployee", DataGenerator.listEmployee);
        return "/employee/employees-table";
    }

    @GetMapping("/employees")
    public String getEmployeesTable(Model model2) {
        model2.addAttribute("listEmployee", DataGenerator.listEmployee);
        return "/employee/employees-table";
    }
}
