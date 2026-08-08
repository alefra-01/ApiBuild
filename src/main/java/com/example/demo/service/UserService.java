package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean checkPassword (User user) {
        String username = user.getUsername();
        Optional<User> encontrado = userRepository.findByUsername(username);
        User usuarioFind = encontrado.get();   // saco el user de la caja
        return passwordEncoder.matches(user.getPassword(), usuarioFind.getPassword());
    }

}
