package com.example.datastorageproject.Model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
/**Переменная price устанавливается только после подтверждения менеджера**/
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
    private Integer price;
    /*Произведена ли машина*/
    private Boolean isProduced;
    /*Доступна ли машина в автосалоне на данный момент*/
    private Boolean isAvailable;
    /*Является ли машина новой или б/у*/
    private Boolean isNew;
//    @OneToMany(fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Invoice> invoiceList;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<TestDrive> testDriveList;
}
