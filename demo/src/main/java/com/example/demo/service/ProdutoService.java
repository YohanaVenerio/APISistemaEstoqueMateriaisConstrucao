package com.example.demo.service;

import com.example.demo.dto.ProdutoDTO;
import com.example.demo.dto.CategoriaDTO;
import com.example.demo.repository.IProdutoRepository;
import com.example.demo.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private ICategoriaRepository categoriaRepository;

    //Salvar produto com a verificação de categoria existente
    public ProdutoDTO salvar(ProdutoDTO produto){
        CategoriaDTO categoria = categoriaRepository.findById(produto.getCategoria().getId())
            .orElseThrow(()->new RuntimeException("Categotia não encontarada"));
        produto.setCategoria(categoria);
        return produtoRepository.save(produto);
    }

    // public Produto cadastar(Produto produto) {
    //     return produtoRepository.save(produto);
    // }

    //Listar todos
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll();
    }

    // public Optional<Produto> buscarPorId(Long id){
    //     return produtoRepository.findById(id);
    // }

    //Buscar por ID
    public ProdutoDTO buscarPorId(Long id){
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    //Atualizar
    public ProdutoDTO atualizar(Long id, ProdutoDTO novoProduto) {
        return produtoRepository.findById(id)
        .map(produto -> {
            produto.setNome(novoProduto.getNome());
            produto.setDescricao(novoProduto.getDescricao());
            produto.setQuantidade(novoProduto.getQuantidade());
            produto.setPrecoUnitario(novoProduto.getPrecoUnitario());
            produto.setCategoria(novoProduto.getCategoria());
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não Encontrado"));
    }

    //Remover
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
