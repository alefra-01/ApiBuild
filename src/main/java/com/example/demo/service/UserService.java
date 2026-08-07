package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /*
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    public List<User> getEveryuser () {
        return userRepository.findAll();
    }

}
