package com.example.demo.controller;

import com.example.demo.Entities.Venda;
import com.example.demo.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> registrar(@RequestBody Venda venda) {
        return ResponseEntity.ok(vendaService.salvar(venda));
    }

    @GetMapping
    public List<Venda> listar() {
        return vendaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
