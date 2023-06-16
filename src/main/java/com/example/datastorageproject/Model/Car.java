package com.example.datastorageproject.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
/**Переменная price устанавливается только после подтверждения менеджера**/
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "make cannot be null")
    private String make;
    @NotBlank(message = "model cannot be null")
    private String model;
    @Min(value = 50, message = "horse power must be more than 50")
    private Integer horsePower;
    @NotBlank(message = "car must have fuel type (electro/gas)")
    private String fuel;
    @NotBlank(message = "car must have color")
    private String color;
    @NotBlank(message = "car must have VIN number")
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
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntityList;
}
