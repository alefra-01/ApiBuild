package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getEveryuser () {
        return userRepository.findAll();
    }

    public User createuser(User user) {
        user.setPassword(hashPass(user.getPassword()));
        return userRepository.save(user);
    }

    private String hashPass (String pass) {
        return  passwordEncoder.encode(pass);
    }

    public boolean  checkPassword (User user) {
        String username = user.getUsername();
        Optional<User> encontrado = userRepository.findByUsername(username);
        User usuarioFind = encontrado.get();
        return passwordEncoder.matches(user.getPassword(), usuarioFind.getPassword());
    }




}
