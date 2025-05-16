package com.example.demo.service;

import com.example.demo.Entities.Produto;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    public Produto cadastar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    public Produto atualizar(Long id, Produto novoProduto) {
        Produto produto = buscarPorId(id);
        produto.setNome(novoProduto.getNome());
        produto.setDescricao(novoProduto.getDescricao());
        produto.setQuantidade(novoProduto.getQuantidade());
        produto.setPrecoUnitario(novoProduto.getPrecoUnitario());
        produto.setCategoriaId(novoProduto.getCategoriaId());
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
