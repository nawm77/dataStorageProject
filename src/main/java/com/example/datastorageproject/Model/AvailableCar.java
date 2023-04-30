package com.example.datastorageproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class AvailableCar {
    @Id
    private Integer id;
    private Integer price;
}
