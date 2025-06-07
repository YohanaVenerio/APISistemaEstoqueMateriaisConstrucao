package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Venda;
import com.example.demo.dto.VendaDTO;
import com.example.demo.Entities.Produto;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, ProdutoMapper.class})
public interface VendaMapper {
    VendaDTO toDTO(Venda venda);

    Venda toEntity(VendaDTO vendaDTO);

    List<VendaDTO> toDTOList(List<Venda> vendas);

    default Long map(Produto produto) {
        return produto == null ? null : produto.getId();
    }

    default Produto map(Long id) {
        if (id == null) return null;
        Produto produto = new Produto();
        produto.setId(id);
        return produto;
    }
}
