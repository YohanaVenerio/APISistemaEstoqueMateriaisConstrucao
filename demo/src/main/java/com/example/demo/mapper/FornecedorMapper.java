package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Fornecedor;
import com.example.demo.dto.FornecedorDTO;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {
    FornecedorDTO toDTO(Fornecedor fornecedor);

    Fornecedor toEntity(FornecedorDTO fornecedorDTO);

    List<FornecedorDTO> toDTOList(List<Fornecedor> fornecedores);
}
