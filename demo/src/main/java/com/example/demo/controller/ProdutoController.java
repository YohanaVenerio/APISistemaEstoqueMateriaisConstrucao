package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProdutoDTO;
import com.example.demo.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoDTO buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping
    public ProdutoDTO salvarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        return produtoService.salvarProduto(produtoDTO);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
