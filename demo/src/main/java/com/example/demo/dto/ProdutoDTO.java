package com.example.demo.dto;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProdutoDTO {
    private Long Id;

    @NotBlank(message = "O nome é obrigatório")
    private String Nome;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Aquantidade é obrigatória")
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    private Integer quantidade;

    @NotNull(message = "O preço unitário é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O prelo deve ser maior que zero")
    private BigDecimal precoUnitario;

    @NotNull(message = "A categoria é obrigatória")
    private Long categoriaId;
}
