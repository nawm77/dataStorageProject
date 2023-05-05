package com.example.datastorageproject.Controller;

import com.example.datastorageproject.DTO.EmployeeDTO;
import com.example.datastorageproject.Model.Car;
import com.example.datastorageproject.Model.Invoice;
import com.example.datastorageproject.Repository.CarRepository;
import com.example.datastorageproject.Repository.InvoiceRepository;
import com.example.datastorageproject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CarRepository carRepository;
    private final InvoiceRepository invoiceRepository;
    @Autowired
    public EmployeeController(EmployeeService employeeService, CarRepository carRepository, InvoiceRepository invoiceRepository) {
        this.employeeService = employeeService;
        this.carRepository = carRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/employee")
    public List<EmployeeDTO> get(){
        return employeeService.getEmployee();
    }

    @GetMapping("/empl")
    public List<Invoice> getCars(){
        return invoiceRepository.findAll();
    }
}
