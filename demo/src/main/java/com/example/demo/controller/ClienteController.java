package com.example.demo.controller;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.Utils.ApiResponse;
import com.example.demo.service.Utils.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Clientes", description = "Endpoints para gerenciamento de clientes")
@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodas() {
        List<ClienteDTO> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Busca um cliente por ID", description = "Retorna os detalhes de um cliente específico")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        Optional<ClienteDTO> clienteDTO = clienteService.buscarPorId(id);//The type Optional is not generic; it cannot be parameterized with arguments <ClienteDTO>Java(16777740)
        return clienteDTO.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cria um novo cliente", description = "Cadastra um novo cliente no sistema")
    @PostMapping
    public ResponseEntity<ApiResponse<ClienteDTO>> criarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO savedCliente = clienteService.salvar(clienteDTO);
            ApiResponse<ClienteDTO> response = new ApiResponse<>(savedCliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            ErrorResponse error = new ErrorResponse("Argumento inválido", e.getMessage());
            return ResponseEntity.badRequest().body(new ApiResponse<>(error));
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse("Erro interno", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(error));
        }
    }

    @Operation(summary = "Deleta um cliente", description = "Remove um cliente do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
