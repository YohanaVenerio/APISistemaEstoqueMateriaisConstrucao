package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Produto;
import com.example.demo.dto.ProdutoDTO;
import com.example.demo.Entities.Categoria;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoDTO toDTO(Produto produto);

    Produto toEntity(ProdutoDTO produtoDTO);

    List<ProdutoDTO> toDTOList(List<Produto> produtos);
    List<Produto> toEntityList(List<ProdutoDTO> produtosDTO);

    // Métodos auxiliares para MapStruct
    default Long map(Categoria categoria) {
        return categoria == null ? null : categoria.getId();
    }

    default Categoria map(Long id) {
        if (id == null) return null;
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return categoria;
    }
}