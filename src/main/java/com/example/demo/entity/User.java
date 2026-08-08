package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @NotBlank(message = "No empty usernames")
    private String username;

    @NotBlank(message = "No empty pass")
    private String password;

    @NotBlank(message = "No empty pass email")
    @Email(message = "Email format incorrect, do not cheat me")
    private String email;
}
