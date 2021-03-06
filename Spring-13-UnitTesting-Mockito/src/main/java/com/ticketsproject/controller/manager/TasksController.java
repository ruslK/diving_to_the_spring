package com.ticketsproject.controller.manager;

import com.ticketsproject.dto.TaskDTO;
import com.ticketsproject.enums.Status;
import com.ticketsproject.servises.ProjectService;
import com.ticketsproject.servises.TaskService;
import com.ticketsproject.servises.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager")
public class TasksController {

    ProjectService projectService;
    UserService userService;
    TaskService taskService;

    public TasksController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("newTask", new TaskDTO());
        model.addAttribute("projects", projectService.listOfProjectsNonComplete());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("allTask", taskService.listOfTasks());
        return "manager/tasks";
    }

    @PostMapping({"/tasks", "/tasks/update/{id}"})
    public String insertNewTasks(@ModelAttribute TaskDTO newTask, @PathVariable (required = false) String id) {
        if(id != null) newTask.setId(Long.parseLong(id));
        taskService.save(newTask);
        return "redirect:/manager/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTasks(@PathVariable String id, Model model) {
        taskService.deleteByID(Long.parseLong(id));
        return "redirect:/manager/tasks";
    }

    @GetMapping("/tasks/update/{id}")
    public String updateTasks(@PathVariable String id, Model model) {
        model.addAttribute("newTask", taskService.findTaskById(Long.parseLong(id)));
        model.addAttribute("projects", projectService.listOfProjectsNonComplete());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("allTask", taskService.listAllTaskByStatusIsNot(Status.COMPLETE));
        return "manager/tasks";
    }
}
