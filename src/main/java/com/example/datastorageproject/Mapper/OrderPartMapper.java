package com.example.datastorageproject.Mapper;

import com.example.datastorageproject.DTO.OrderPartDTO;
import com.example.datastorageproject.Model.OrderPart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderPartMapper {
    OrderPartMapper INSTANCE = Mappers.getMapper(OrderPartMapper.class);
    OrderPartDTO toDTO(OrderPart order);
}
