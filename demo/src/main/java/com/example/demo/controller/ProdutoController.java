package com.example.demo.controller;

import com.example.demo.Entities.Produto;
import com.example.demo.service.ProdutoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criarProduto(@Valid @RequestBody Produto produto){
        return produtoService.salvar(produto);
    }
    
    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto){
        return produtoService.atualizar(id,produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletar(id);
    }
}
