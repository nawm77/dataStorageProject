package com.example.datastorageproject.Service;

import com.example.datastorageproject.DTO.EmployeeDTO;
import com.example.datastorageproject.Model.Employee;
import com.example.datastorageproject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(e -> new EmployeeDTO(
                        e.getId(),
                        e.getName(),
                        e.getSurname(),
                        e.getPhoneNumber(),
                        e.getEmail()))
                .collect(Collectors.toList());
    }
}
