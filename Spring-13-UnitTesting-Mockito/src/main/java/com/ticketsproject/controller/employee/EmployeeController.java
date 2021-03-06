package com.ticketsproject.controller.employee;

import com.ticketsproject.dto.TaskDTO;
import com.ticketsproject.enums.Status;
import com.ticketsproject.servises.ProjectService;
import com.ticketsproject.servises.TaskService;
import com.ticketsproject.servises.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final TaskService taskService;
    private final UserService userService;
    private final ProjectService projectService;

    public EmployeeController(TaskService taskService, UserService userService, ProjectService projectService) {
        this.taskService = taskService;
        this.userService = userService;
        this.projectService = projectService;
    }


    @GetMapping("/tasks")
    public String getCreateProjectsPage(Model model) {
        List<TaskDTO> tasks = taskService.listAllTaskByStatusIsNot(Status.COMPLETE);
        model.addAttribute("tasks", tasks);
        return "employee/pendingTask";
    }

    @GetMapping("/tasks/update/{id}")
    public String updateEmployeeTask(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.findTaskById(id));
        model.addAttribute("allTask", taskService.listAllTaskByStatusIsNot(Status.COMPLETE));
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("projects", projectService.listOfProjectsNonComplete());
        model.addAttribute("statutes", Status.values());

        return "employee/updateTasks";
    }

    @PostMapping("/tasks/update/{id}")
    public String saveUpdateTaskStatus(@PathVariable("id") String id, @ModelAttribute TaskDTO task) {
        TaskDTO updatedTask = taskService.findTaskById(task.getId());
        updatedTask.setStatus(task.getStatus());
        taskService.save(updatedTask);
        return "redirect:/employee/tasks";
    }

    @GetMapping("/archive")
    public String archive(Model model) {
        List<TaskDTO> tasks = taskService.listAllTaskByStatus(Status.COMPLETE);
        model.addAttribute("tasks", tasks);
        return "employee/archive";
    }

}
