package com.example.datastorageproject.Model;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Employee extends User {
    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<TestDrive> testDriveLists;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Invoice> invoiceList;
}
