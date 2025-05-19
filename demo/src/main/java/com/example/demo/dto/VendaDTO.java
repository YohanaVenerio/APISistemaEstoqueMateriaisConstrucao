package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VendaDTO {
    private Long id;

    @NotBlank(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotBlank(message = "O ID do produto é obrigatório")
    private Long produtoId;

    @NotBlank(message = "A quantidade é obrigatória")
    @Min(value = 0, message = "A quantidade deve ser maior que zero")
    private Integer quantidade;

    @NotBlank(message = "O valor total é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor total deve ser maior que zero")
    private BigDecimal valorTotal;

    @NotBlank(message = "A data da venda é obrigatória")
    private LocalDateTime dataVenda;
}
