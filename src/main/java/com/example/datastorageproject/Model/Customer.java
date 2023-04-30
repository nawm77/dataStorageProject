package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String phoneNumber;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderTable> orderList;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Testdrive_list> testDriveLists;

}
