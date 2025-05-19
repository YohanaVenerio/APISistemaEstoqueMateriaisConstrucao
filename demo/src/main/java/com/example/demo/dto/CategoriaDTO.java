package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {
    private Long id;

    @NotBlank(message = "O noem é obrigatório")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    private String descrição;
    
}
