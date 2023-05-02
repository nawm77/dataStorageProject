package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AvailableCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer price;
}
