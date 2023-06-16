package com.example.datastorageproject.Model;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

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
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.REMOVE)
    private List<OrderPart> orderPartList;
    private String description;
    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;
}
