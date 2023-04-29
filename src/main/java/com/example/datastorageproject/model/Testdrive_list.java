package com.example.datastorageproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Testdrive_list {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
