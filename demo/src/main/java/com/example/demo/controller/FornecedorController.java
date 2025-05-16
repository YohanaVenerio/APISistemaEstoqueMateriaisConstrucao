package com.example.demo.controller;

import com.example.demo.Entities.Fornecedor;

import com.example.demo.service.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> criar(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(fornecedorService.salvar(fornecedor));
    }

    @GetMapping
    public List<Fornecedor> listar() {
        return fornecedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(fornecedorService.atualizar(id, fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
