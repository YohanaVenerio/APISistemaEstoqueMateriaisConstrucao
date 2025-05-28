package com.example.demo.service;

import com.example.demo.dto.CompraDTO;
import com.example.demo.dto.FornecedorDTO;
import com.example.demo.dto.ProdutoDTO;
import com.example.demo.repository.ICompraRepository;
import com.example.demo.repository.IFornecedorRepository;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Autowired
    private IFornecedorRepository fornecedorRepository;

    @Autowired
    private IProdutoRepository produtoRepository;

    public CompraDTO registrarCompra(Long fornecedorId, Long produtoId, int quantidade) {
        FornecedorDTI fornecedor = fornecedorRepository.findById(fornecedorId)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        ProdutoDTO produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        CompraDTO compra = new CompraDTO();
        compra.setFornecedor(fornecedor);
        compra.setProduto(produto);
        compra.setQuantidade(quantidade);
        compra.setValorTotal(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(quantidade)));
        return compraRepository.save(compra);
    }

    public List<CompraDTO> listar() {
        return compraRepository.findAll();
    }

    public CompraDTO buscarPorId(Long id) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra não encontrada"));
    }

    public List<CompraDTO> listarPorFornecedor(Long fornecedorId) {
        return compraRepository.findByFornecedorId(fornecedorId);
    }

    public List<CompraDTO> listarPorProduto(Long produtoId) {
        return compraRepository.findByProdutoId(produtoId);
    }

    public CompraDTO atualizar(Long id, int novaQuantidade) {
        CompraDTO compra = buscarPorId(id);
        compra.setQuantidade(novaQuantidade);
        compra.setValorTotal(compra.getProduto().getPrecoUnitario().multiply(BigDecimal.valueOf(novaQuantidade)));

        return compraRepository.save(compra);
    }

    public void deletar(Long id) {
        compraRepository.deleteById(id);
    }
}