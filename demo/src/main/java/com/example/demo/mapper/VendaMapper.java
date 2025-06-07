package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

import com.example.demo.Entities.Venda;
import com.example.demo.dto.VendaDTO;
import com.example.demo.Entities.Produto;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, ProdutoMapper.class})
public interface VendaMapper {
   @Mappings({
        @Mapping(source = "cliente.id", target = "clienteId"),
        @Mapping(source = "produto.id", target = "produtoId")
    })
    VendaDTO toDTO(Venda venda);

    @Mappings({
        @Mapping(source = "clienteId", target = "cliente"),
        @Mapping(source = "produtoId", target = "produto")
    })
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

    default Long map(com.example.demo.Entities.Cliente cliente) {
        return cliente == null ? null : cliente.getId();
    }

    default com.example.demo.Entities.Cliente mapCliente(Long id) {
        if (id == null) return null;
        com.example.demo.Entities.Cliente cliente = new com.example.demo.Entities.Cliente();
        cliente.setId(id);
        return cliente;
    }
}
