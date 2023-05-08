package com.example.datastorageproject.Mapper;

import com.example.datastorageproject.DTO.InvoiceDTO;
import com.example.datastorageproject.Model.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);
    InvoiceDTO toDTO(Invoice invoice);
}
