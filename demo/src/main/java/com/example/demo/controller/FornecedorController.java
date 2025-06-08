package com.example.demo.controller;

import com.example.demo.dto.FornecedorDTO;
import com.example.demo.service.FornecedorService;
import com.example.demo.service.Utils.ApiResponse;
import com.example.demo.service.Utils.ErrorResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fornecedores")
@Tag(name = "Fornecedores", description = "Endpoints para gerenciamento de fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> listarTodas() {
        List<FornecedorDTO> fornecedores = fornecedorService.listarTodos();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> buscarPorId(@PathVariable Long id) {
        Optional<FornecedorDTO> fornecedorDTO = fornecedorService.buscarPorId(id);
        return fornecedorDTO.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<FornecedorDTO>> criarFornecedor(@Valid @RequestBody FornecedorDTO fornecedorDTO) {
        try {
            FornecedorDTO saved = fornecedorService.salvar(fornecedorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(saved));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(new ApiResponse<>(new ErrorResponse("Erro ao criar fornecedor", e.getMessage())));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        Optional<FornecedorDTO> fornecedor = fornecedorService.buscarPorId(id);
        if (fornecedor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        fornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
