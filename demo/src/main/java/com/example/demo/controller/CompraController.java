package com.example.demo.controller;

import com.example.demo.Entities.Compra;
import com.example.demo.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> registrar(@RequestBody Map<String, Object> payload) {
        Long fornecedorId = Long.valueOf(payload.get("fornecedorId").toString());
        Long produtoId = Long.valueOf(payload.get("produtoId").toString());
        int quantidade = Integer.parseInt(payload.get("quantidade").toString());

        Compra compra = compraService.registrarCompra(fornecedorId, produtoId, quantidade);
        return ResponseEntity.ok(compra);
    }

    @GetMapping
    public List<Compra> listar() {
        return compraService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(compraService.buscarPorId(id));
    }

    @GetMapping("/fornecedor/{fornecedorId}")
    public List<Compra> listarPorFornecedor(@PathVariable Long fornecedorId) {
        return compraService.listarPorFornecedor(fornecedorId);
    }

    @GetMapping("/produto/{produtoId}")
    public List<Compra> listarPorProduto(@PathVariable Long produtoId) {
        return compraService.listarPorProduto(produtoId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizar(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        int quantidade = body.get("quantidade");
        return ResponseEntity.ok(compraService.atualizar(id, quantidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        compraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
