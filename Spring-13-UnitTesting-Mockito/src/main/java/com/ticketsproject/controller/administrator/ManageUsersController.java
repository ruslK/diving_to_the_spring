package com.ticketsproject.controller.administrator;

import com.ticketsproject.dto.UserDTO;
import com.ticketsproject.exception.TicketingProjectException;
import com.ticketsproject.servises.RoleService;
import com.ticketsproject.servises.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Component
@Controller
@RequestMapping("/administrator")
public class ManageUsersController {

    RoleService roleService;
    UserService userService;

    public ManageUsersController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("allUsers", userService.listAllUsers());
        model.addAttribute("roles", roleService.listAllRoles());
        return "administrator/createUser";
    }

    @PostMapping("/users")
    public String postUsers(@ModelAttribute("newUser") UserDTO newUser, Model model) {
        userService.save(newUser);
        return "redirect:/administrator/users";
    }

    @GetMapping("/users/update/{id}")
    public String updateUser(@PathVariable("id") String id, Model model) {
        model.addAttribute("newUser", userService.findByUserName(id));
        model.addAttribute("allUsers", userService.listAllUsers());
        model.addAttribute("roles", roleService.listAllRoles());
        return "administrator/createUser";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        try {
            userService.delete(id);
            return "redirect:/administrator/users";
        } catch (TicketingProjectException e) {
            e.printStackTrace();
            return "redirect:/administrator/users";
        }

    }
}
