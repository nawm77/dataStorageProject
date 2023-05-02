package com.example.datastorageproject.Mapper;

import com.example.datastorageproject.DTO.EmployeeDTO;
import com.example.datastorageproject.Model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper((EmployeeMapper.class));
    EmployeeDTO toDTO(Employee employee);
}
