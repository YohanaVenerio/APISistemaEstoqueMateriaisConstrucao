package com.example.demo.service;

import com.example.demo.Entities.Compra;
import com.example.demo.Entities.Fornecedor;
import com.example.demo.Entities.Produto;
import com.example.demo.repository.ICompraRepository;
import com.example.demo.repository.IFornecedorRepository;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Autowired
    private IFornecedorRepository fornecedorRepository;

    @Autowired
    private IProdutoRepository produtoRepository;

    public Compra registrarCompra(Long fornecedorId, Long produtoId, int quantidade) {
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Compra compra = new Compra();
        compra.setFornecedor(fornecedor);
        compra.setProduto(produto);
        compra.setQuantidade(quantidade);
        compra.setValorTotal(produto.getPrecoUnitario() * quantidade); 
        return compraRepository.save(compra);
    }

    public List<Compra> listar() {
        return compraRepository.findAll();
    }

    public Compra buscarPorId(Long id) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra não encontrada"));
    }

    public List<Compra> listarPorFornecedor(Long fornecedorId) {
        return compraRepository.findByFornecedorId(fornecedorId);
    }

    public List<Compra> listarPorProduto(Long produtoId) {
        return compraRepository.findByProdutoId(produtoId);
    }

    public Compra atualizar(Long id, int novaQuantidade) {
        Compra compra = buscarPorId(id);
        compra.setQuantidade(novaQuantidade);
        compra.setValorTotal(compra.getProduto_Id().getPreco() * novaQuantidade);
        return compraRepository.save(compra);
    }

    public void deletar(Long id) {
        compraRepository.deleteById(id);
    }
}