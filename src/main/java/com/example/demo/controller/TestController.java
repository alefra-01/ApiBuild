package com.example.demo.controller;

import com.example.demo.exception.ApiBuilException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String InitializationController () {
        String controlMe = "Correct";
        log.info("/test initialized");
        return controlMe;

    }

}
