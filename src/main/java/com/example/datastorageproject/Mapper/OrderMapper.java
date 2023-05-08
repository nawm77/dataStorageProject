package com.example.datastorageproject.Mapper;

import com.example.datastorageproject.DTO.OrderDTO;
import com.example.datastorageproject.Model.OrderEntity;
import org.aspectj.weaver.ast.Or;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDTO toDTO(OrderEntity order);
}
