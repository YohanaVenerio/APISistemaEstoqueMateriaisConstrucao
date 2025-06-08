package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.Entities.Produto;
import com.example.demo.dto.ProdutoDTO;
import com.example.demo.Entities.Categoria;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(source = "categoria.id", target = "categoriaId")
    ProdutoDTO toDTO(Produto produto);

    @Mapping(source = "categoriaId", target = "categoria")
    Produto toEntity(ProdutoDTO produtoDTO);

    List<ProdutoDTO> toDTOList(List<Produto> produtos);
    List<Produto> toEntityList(List<ProdutoDTO> produtosDTO);

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