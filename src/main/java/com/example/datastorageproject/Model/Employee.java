package com.example.datastorageproject.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Employee extends User {

    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<TestDrive> testDriveLists;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Invoice> invoiceList;
}
