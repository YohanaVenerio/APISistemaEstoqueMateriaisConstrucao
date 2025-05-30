package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Venda;
import com.example.demo.dto.VendaDTO;

@Mapper(componentModel = "spring")
public interface VendaMapper {
    VendaDTO toDTO(Venda venda);

    Venda toEntity(VendaDTO vendaDTO);

    List<VendaDTO> toDTOList(List<Venda> vendas);
}
