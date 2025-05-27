package com.example.demo.controller;

import com.example.demo.Entities.Categoria;
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
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.salvar(categoria));
    }

    //Listar
    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarTodas();
    }

    //Detalhar Por Id
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }
    
    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.atualizar(id, categoria));
    }

    //Remover
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        categoriaService.remove(id);
    }

    //listar categoria com seus produtos
    @GetMapping("/produtos")
    public List<Categoria> listarComProdutos() {
        return categoriaService.listarComProdutos();
    }
}