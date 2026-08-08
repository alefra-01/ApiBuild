package com.example.demo.service;

import com.example.demo.entity.User;
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

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final PasswordEncoder passwordEncoder;

    /*
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    public List<User> getEveryuser () {
        return userRepository.findAll();
    }

    public User createuser(User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        return userRepository.save(user);
    }

    public boolean checkPassword (User user) {
        String username = user.getUsername();
        Optional<User> encontrado = userRepository.findByUsername(username);
        User usuarioFind = encontrado.get();
        return passwordEncoder.matches(user.getPassword(), usuarioFind.getPassword());
    }
}
