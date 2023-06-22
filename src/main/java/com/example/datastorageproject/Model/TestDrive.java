package com.example.datastorageproject.Model;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class TestDrive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "carVinNumber")
    private Car car;
}
