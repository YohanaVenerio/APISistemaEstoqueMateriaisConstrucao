package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FornecedorDTO {
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(min = 14,max = 14, message = "O CNPJ deve ter 14 caracteres")
    private String cnpj;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
}
