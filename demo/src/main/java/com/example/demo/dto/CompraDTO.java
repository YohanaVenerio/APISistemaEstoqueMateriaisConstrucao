package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompraDTO {
    private Long id;

    @NotBlank(message = "O id do fornecedor é obrigatório")
    private long fornecedorId;

    @NotBlank(message = "O id do produto é obrigatório")
    private Long produtoId;

    @NotBlank(message = "A quantidade é obrigatória")
    @Min(value = 0, message = "A quantidade deve ser maior que 0")
    private Integer quantidade;

    @NotBlank(message = "O valor total é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor total deve ser positivo")
    private BigDecimal valorTotal;

    @NotBlank(message = "A data da Venda é obrigatória")
    private LocalDateTime dataCompra;

}
