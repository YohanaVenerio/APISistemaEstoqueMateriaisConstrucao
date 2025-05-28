package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Compra;
import com.example.demo.dto.CompraDTO;

@Mapper(componentModel = "spring")
public class CompraMapper {
    
    CompraDTO toDTO(Compra compra) {
        if (compra == null){
            return null;
        }
        CompraDTO dto = new CompraDTO();
        dto.setId(compra.getId());
        dto.setDataCompra(compra.getDataCompra());
        dto.setValorTotal(compra.getValorTotal());
        dto.setFornecedorId(compra.getFornecedor().getId());
        dto.setProdutoId(compra.getProduto().getId());
        dto.setQuantidade(compra.getQuantidade());
        dto.setStatusCompra(compra.getStatusCompra());
        return dto;
    }
}
