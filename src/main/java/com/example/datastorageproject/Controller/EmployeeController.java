package com.example.datastorageproject.Controller;

import com.example.datastorageproject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String get(){
        return employeeRepository.findAll().toString();
    }
}
