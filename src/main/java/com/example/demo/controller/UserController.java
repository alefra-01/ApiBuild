package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exception.InvalidTokenException;
import com.example.demo.security.JwtService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@Valid
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/user-test")
    public List<User> getEveryuserHere () {
        return userService.getEveryuser();
    }

    @PostMapping("/user-testing-postway")
    public User createANewUser(@Valid @RequestBody User user) {
        return userService.createuser(user);
    }

    @PostMapping("/login")
    public String loginUser (User user) {
        boolean valido = userService.checkPassword(user);
        if (valido) {
            return jwtService.tokenGenerator(user.getUsername());
        } else {
            throw new InvalidTokenException("Invalid credentials");
        }
    }

}
