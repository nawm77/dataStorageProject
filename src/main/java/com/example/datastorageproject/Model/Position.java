package com.example.datastorageproject.Model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String positionName;
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

}
