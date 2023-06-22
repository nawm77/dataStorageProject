package com.example.datastorageproject.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    @Email(message = "incorrect email")
    private String email;
    private String phoneNumber;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
