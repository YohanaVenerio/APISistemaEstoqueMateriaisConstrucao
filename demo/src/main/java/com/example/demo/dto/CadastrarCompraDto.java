package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter
public class CadastrarCompraDto {

    @Positive(message = "A quantidade tem que serpositivo")
    @NotNull(message = "A quantidade deve ser inserida")
    private Integer quantidade;

    @NotNull
    private BigDecimal valorTotal;

    @NotNull
    private Long fornecedorId;

    @NotNull
    private LocalDateTime dataComprDateTime;



}
