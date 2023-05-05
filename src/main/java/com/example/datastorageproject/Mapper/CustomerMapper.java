package com.example.datastorageproject.Mapper;

import com.example.datastorageproject.DTO.CustomerDTO;
import com.example.datastorageproject.Model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO toDTO(Customer customer);
}
