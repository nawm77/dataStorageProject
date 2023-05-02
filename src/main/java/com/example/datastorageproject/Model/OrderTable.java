package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "orderStatusId")
    private OrderStatus orderStatus;
    private LocalDateTime deliveryDate;

    @OneToOne
    @JoinColumn(name = "carVinNumber")
    private AvailableCar availableCar;
}
