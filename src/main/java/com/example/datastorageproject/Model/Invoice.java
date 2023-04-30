package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
