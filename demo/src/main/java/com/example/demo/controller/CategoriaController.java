package com.example.demo.controller;

import com.example.demo.dto.CategoriaDTO;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //Criar a categoria
    @PostMapping
    public ResponseEntity<CategoriaDTO> criar(@RequestBody CategoriaDTO categoria) {
        return ResponseEntity.ok(categoriaService.salvar(categoria));
    }

    //Listar
    @GetMapping
    public List<CategoriaDTO> listar() {
        return categoriaService.listarTodas();
    }

    //Detalhar Por Id
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }
    
    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long id, @RequestBody CategoriaDTO categoria) {
        return ResponseEntity.ok(categoriaService.atualizar(id, categoria));
    }

    //Remover
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
    }

    //listar categoria com seus produtos
    @GetMapping("/produtos")
    public List<CategoriaDTO> listarComProdutos() {
        return categoriaService.listarComProdutos();
    }
}