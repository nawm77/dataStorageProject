package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @OneToMany(mappedBy = "invoice")
    private List<OrderPart> orderPartList;
    private String description;
    @ManyToOne
    @JoinColumn(name = "carVinNumber")
    private Car car;
}
