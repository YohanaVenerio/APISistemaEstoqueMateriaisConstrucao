package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;


import com.example.demo.Entities.Compra;
import com.example.demo.dto.CompraDTO;

@Mapper(componentModel = "spring")
public interface CompraMapper {
    
    CompraDTO toDTO(Compra compra);

    Compra toEntity(CompraDTO compraDTO);

    List<CompraDTO> toDTOList(List<Compra> compras);
}
