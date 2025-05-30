package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Produto;
import com.example.demo.dto.ProdutoDTO;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoDTO toDTO(Produto produto);

    Produto toEntity(ProdutoDTO produtoDTO);

    List<ProdutoDTO> toDTOList(List<Produto> produtos);
}
