package com.example.datastorageproject.Model;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "orderStatusId")
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;
    private LocalDateTime deliveryDate;
}
