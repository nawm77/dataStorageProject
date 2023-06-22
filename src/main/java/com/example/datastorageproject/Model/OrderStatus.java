package com.example.datastorageproject.Model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntityList;
}
