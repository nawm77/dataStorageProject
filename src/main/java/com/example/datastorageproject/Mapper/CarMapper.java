package com.example.datastorageproject.Mapper;

import com.example.datastorageproject.DTO.CarDTO;
import com.example.datastorageproject.Model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    CarDTO toDTO(Car car);
}
