package com.authentification.controller;

import com.authentification.annotation.DefaultExceptionMessage;
import com.authentification.entity.ResponseWrapper;
import com.authentification.entity.User;
import com.authentification.exeption.ServiceException;
import com.authentification.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Tag(name="User Controller", description = "User's API")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/read")
//    @PreAuthorize("hasAnyAuthority('USER')")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @DefaultExceptionMessage(defaultMessage = "Test")
    @Operation(summary = "Get All user")
    public ResponseEntity<ResponseWrapper> readAll () {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(new ResponseWrapper("Done", users));
    }

    @GetMapping("/read2")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ResponseWrapper> readAllTwo () {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(new ResponseWrapper("Done", users));
    }

    @PostMapping("/createUser")
    @DefaultExceptionMessage(defaultMessage = "Test")
    @Operation(summary = "Create a new User")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody User user) throws ServiceException {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(new ResponseWrapper("User has be created successfully", createdUser));
    }
}
