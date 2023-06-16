package com.example.datastorageproject.Mapper;

import com.example.datastorageproject.DTO.PartDTO;
import com.example.datastorageproject.Model.Part;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PartMapper {
    PartMapper INSTANCE = Mappers.getMapper(PartMapper.class);
    PartDTO toDTO(Part part);
}
