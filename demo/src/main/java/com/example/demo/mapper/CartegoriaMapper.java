package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Categoria;
import com.example.demo.dto.CategoriaDTO;

@Mapper(componentModel = "spring")
public class CartegoriaMapper {
    CategoriaDTO toDTO(Categoria categoria) {
        if (categoria == null) {
            return null;
        }
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }

    Categoria toEntity(CategoriaDTO categoriaDTO) {
        if (categoriaDTO == null) {
            return null;
        }
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.getId());
        categoria.setNome(categoriaDTO.getNome());
        return categoria;
    }

    List<CategoriaDTO> toDTOList(List<Categoria> categorias) {
        if (categorias == null) {
            return null;
        }
        return categorias.stream().map(this::toDTO).toList();
    }
}
