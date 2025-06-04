package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.demo.Entities.Fornecedor;
import com.example.demo.dto.FornecedorDTO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FornecedorMapper {
    FornecedorDTO toDTO(Fornecedor fornecedor);
    List<FornecedorDTO> toDTOList(List<Fornecedor> fornecedores);
    Fornecedor toEntity(FornecedorDTO fornecedorDTO);
}
