package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Position {
    @Id
    @GeneratedValue
    private Integer id;
    private String positionName;
    private Integer salary;
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Employee> employeeList;
}
