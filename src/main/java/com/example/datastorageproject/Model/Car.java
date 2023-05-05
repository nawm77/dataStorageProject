package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String make;
    private String model;
    private Integer horsePower;
    private String fuel;
    private String color;
    private String carVinNumber;
    private Boolean isProduced;
    private Boolean isAvailable;
}
