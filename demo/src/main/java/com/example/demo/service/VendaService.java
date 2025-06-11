package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Venda;
import com.example.demo.Entities.Cliente;
import com.example.demo.Entities.Produto;
import com.example.demo.dto.VendaDTO;
import com.example.demo.mapper.VendaMapper;
import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.IProdutoRepository;
import com.example.demo.repository.IVendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VendaService {

    @Autowired
    private IVendaRepository vendaRepository;

    @Autowired
    private IClienteRepository IClienteRepository;

    @Autowired
    private IProdutoRepository IProdutoRepository;

    @Autowired
    private VendaMapper vendaMapper;

    public List<VendaDTO> listarTodasVendas() {
        return vendaMapper.toDTOList(vendaRepository.findAll());
    }

    public VendaDTO buscarVendaPorId(Long id) {
        return vendaRepository.findById(id)
                .map(vendaMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada com o ID: " + id));
    }

    public VendaDTO salvarVenda(VendaDTO vendaDTO) {

        if (vendaDTO.getQuantidade() <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");

        }
        Cliente cliente = IClienteRepository.findById(vendaDTO.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Produto produto = IProdutoRepository.findById(vendaDTO.getProdutoId())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        if (produto.getQuantidade() < vendaDTO.getQuantidade()) {
            throw new IllegalArgumentException("Quantidade em estoque insuficiente.");
        }

        produto.setQuantidade(produto.getQuantidade() - vendaDTO.getQuantidade());
        IProdutoRepository.save(produto);

        Venda venda = vendaMapper.toEntity(vendaDTO);
        venda.setCliente(cliente);
        venda.setProduto(produto);

        if (vendaDTO.getValorTotal() == null) {
            venda.setValorTotal(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(vendaDTO.getQuantidade())));
        }

        return vendaMapper.toDTO(vendaRepository.save(venda));
    }

    public void deletarVenda(Long id) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada"));

        Produto produto = venda.getProduto();
        produto.setQuantidade(produto.getQuantidade() + venda.getQuantidade());
        IProdutoRepository.save(produto);

        vendaRepository.deleteById(id);
    }
}
