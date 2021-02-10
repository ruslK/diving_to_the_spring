package com.authentification.controller;

import com.authentification.entity.ResponseWrapper;
import com.authentification.entity.User;
import com.authentification.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/read")
//    @PreAuthorize("hasAnyAuthority('USER')")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
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
}
