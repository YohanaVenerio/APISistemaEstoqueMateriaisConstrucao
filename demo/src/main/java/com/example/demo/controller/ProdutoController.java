package com.example.demo.controller;

import com.example.demo.dto.ProdutoDTO;
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
    public ProdutoDTO criarProduto(@Valid @RequestBody ProdutoDTO produto){
        return produtoService.salvar(produto);
    }
    
    @GetMapping
    public List<ProdutoDTO> listarProdutos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ProdutoDTO atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produto){
        return produtoService.atualizar(id,produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletar(id);
    }
}
