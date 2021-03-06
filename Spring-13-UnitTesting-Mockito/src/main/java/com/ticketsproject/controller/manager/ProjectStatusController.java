package com.ticketsproject.controller.manager;

import com.ticketsproject.servises.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ProjectStatusController {

    private final ProjectService projectService;


    public ProjectStatusController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/status")
    public String getListProjectStatuses(Model model) {
        model.addAttribute("projects", projectService.getAllProjectByManagerId());
        return "manager/projectStatus";
    }


    @GetMapping("/status/update/{projectCode}")
    public String completeProject(@PathVariable String projectCode) {
        projectService.complete(projectCode);
        return "redirect:/manager/status";
    }
}
