package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String phoneNumber;
    private String email;
    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Testdrive_list> testDriveLists;
}
