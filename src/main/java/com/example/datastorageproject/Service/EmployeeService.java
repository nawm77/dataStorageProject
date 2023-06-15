package com.example.datastorageproject.Service;

import com.example.datastorageproject.DTO.EmployeeDTO;
import com.example.datastorageproject.Mapper.EmployeeMapper;
import com.example.datastorageproject.Model.Employee;
import com.example.datastorageproject.Repository.EmployeeRepository;
import com.example.datastorageproject.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final PositionRepository positionRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.positionRepository = positionRepository;
    }

    public List<EmployeeDTO> getEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.getById(id);
    }

    public void updateEmployee(Integer id, Employee employee){
        employeeRepository.deleteById(id);
        employee.setId(id);
        employeeRepository.save(employee);
    }

    public void saveEmployee(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
    }

    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
}
