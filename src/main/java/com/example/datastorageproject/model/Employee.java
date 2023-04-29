package com.example.datastorageproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String phoneNumber;
    private String email;
    private Integer positionId;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Testdrive_list> testDriveLists;
}
