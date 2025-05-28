package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {
    private Long id;

    @NotBlank(message = "O noem é obrigatório")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
