package com.example.datastorageproject.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "partId")
    private Part part;
    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;
}
