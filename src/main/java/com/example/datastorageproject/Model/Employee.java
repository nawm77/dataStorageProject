package com.example.datastorageproject.Model;

import javax.persistence.*;

import com.example.datastorageproject.Repository.PositionRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

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
