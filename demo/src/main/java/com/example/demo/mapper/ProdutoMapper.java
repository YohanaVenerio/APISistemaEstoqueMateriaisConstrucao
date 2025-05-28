package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Produto;
import com.example.demo.dto.ProdutoDTO;

@Mapper(componentModel = "spring")
public class ProdutoMapper {
    ProdutoDTO toDTO(Produto produto) {
        if (produto == null) {
            return null;
        }
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPrecoUnitario(produto.getPrecoUnitario());
        return dto;
    }

    Produto toEntity(ProdutoDTO produtoDTO) {
        if (produtoDTO == null) {
            return null;
        }
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setPrecoUnitario(produtoDTO.getPrecoUnitario());
        return produto;
    }

    List<ProdutoDTO> toDTOList(List<Produto> produtos) {
        if (produtos == null) {
            return null;
        }
        return produtos.stream().map(this::toDTO).toList();
    }
}
