package com.example.datastorageproject.Service;

import com.example.datastorageproject.DTO.PartDTO;
import com.example.datastorageproject.Mapper.PartMapper;
import com.example.datastorageproject.Model.Part;
import com.example.datastorageproject.Repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartService {
    private final PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }
    public List<Part> getAllParts(){
        return partRepository.findAll();
    }

    public List<PartDTO> getAllPartsDTO(){
        return partRepository.findAll()
                .stream()
                .map(PartMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
