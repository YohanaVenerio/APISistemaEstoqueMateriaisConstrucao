package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.Entities.Compra;
import com.example.demo.dto.CompraDTO;

@Mapper(componentModel = "spring")
public interface CompraMapper {

    @Mapping(source = "fornecedor.id", target = "fornecedorId")
    @Mapping(source = "produto.id", target = "produtoId")
    CompraDTO toDTO(Compra compra);

    @Mapping(source = "fornecedorId", target = "fornecedor.id")
    @Mapping(source = "produtoId", target = "produto.id")
    Compra toEntity(CompraDTO compraDTO);

    List<CompraDTO> toDTOList(List<Compra> compras);
}
