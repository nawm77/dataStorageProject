package com.example.datastorageproject.Service;

import com.example.datastorageproject.DTO.EmployeeDTO;
import com.example.datastorageproject.Mapper.EmployeeMapper;
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
//        return employees.stream()
//                .map(e -> new EmployeeDTO(
//                        e.getId(),
//                        e.getName(),
//                        e.getSurname(),
//                        e.getPhoneNumber(),
//                        e.getEmail()))
//                .collect(Collectors.toList());
//
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
        Employee existempl = employeeRepository.getById(employee.getId());
        employee.setPosition(existempl.getPosition());
        employee.setPassword(existempl.getPassword());
        employee.setRole(existempl.getRole());
        employee.setStatus(existempl.getStatus());
        employee.setUsername(existempl.getUsername());
        employeeRepository.save(employee);
    }
}
