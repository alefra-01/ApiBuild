package com.example.demo.controller;

import com.example.demo.exception.ApiBuilException;
import com.example.demo.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Scanner;

@Slf4j
public class ExceptionTestController {

    @GetMapping("/testException")
    public String InitializaTestController () throws ApiBuilException {
        String controlMe = "Correct";
        log.info("/test initialized");
        return controlMe;

    }
}
