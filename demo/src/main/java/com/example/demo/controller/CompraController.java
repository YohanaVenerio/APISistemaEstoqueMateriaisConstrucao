package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CompraDTO;
import com.example.demo.service.CompraService;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<CompraDTO>> listarTodasCompras() {
        List<CompraDTO> compras = compraService.listarTodasCompras();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> buscarCompraPorId(@PathVariable Long id) {
        CompraDTO compra = compraService.buscarCompraPorId(id);
        return compra != null ? ResponseEntity.ok(compra) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CompraDTO> salvarCompra(@RequestBody CompraDTO compraDTO) {
        CompraDTO savedCompra = compraService.salvarCompra(compraDTO);
        return ResponseEntity.ok(savedCompra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCompra(@PathVariable Long id) {
        compraService.deletarCompra(id);
        return ResponseEntity.noContent().build();
    }
}
