package com.authentification.controller;

import com.authentification.annotation.DefaultExceptionMessage;
import com.authentification.entity.AuthenticationRequest;
import com.authentification.entity.ResponseWrapper;
import com.authentification.entity.User;
import com.authentification.service.UserService;
import com.authentification.util.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="Authenticate Controller", description = "Authentication API")
public class AuthController {

    private final JWTUtil jwtUtil;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JWTUtil jwtUtil, UserService userService, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    @DefaultExceptionMessage(defaultMessage = "Bad Cridential")
    @Operation(summary = "Login to Application")
    public ResponseEntity<ResponseWrapper> getToken(@RequestBody AuthenticationRequest body) {
        String password = body.getPassword();
        String username = body.getUsername();
        User foundUser = userService.readByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        authenticationManager.authenticate(authenticationToken);
        String jwtUtil = this.jwtUtil.generateToken(foundUser, username);
        return ResponseEntity.ok(new ResponseWrapper("Login Successful!", jwtUtil));
    }
}
