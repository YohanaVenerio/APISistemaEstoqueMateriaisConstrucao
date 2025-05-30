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

import com.example.demo.dto.VendaDTO;
import com.example.demo.service.VendaService;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaDTO>> listarTodasVendas() {
        List<VendaDTO> vendas = vendaService.listarTodasVendas();
        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDTO> buscarVendaPorId(@PathVariable Long id) {
        VendaDTO venda = vendaService.buscarVendaPorId(id);
        return venda != null ? ResponseEntity.ok(venda) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VendaDTO> salvarVenda(@RequestBody VendaDTO vendaDTO) {
        VendaDTO savedVenda = vendaService.salvarVenda(vendaDTO);
        return ResponseEntity.ok(savedVenda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
        return ResponseEntity.noContent().build();
    }
}
