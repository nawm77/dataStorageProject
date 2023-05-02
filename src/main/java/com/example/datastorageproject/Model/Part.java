package com.example.datastorageproject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer availableCount;
    private String name;
    private Integer price;
    @OneToMany(mappedBy = "parts", cascade = CascadeType.ALL)
    private List<OrderPart> orderPartList;
}
