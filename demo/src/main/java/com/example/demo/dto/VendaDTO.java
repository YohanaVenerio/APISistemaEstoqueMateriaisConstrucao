package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private Integer quantidade;

    @NotBlank(message = "O valor total é obrigatório")
    @DecimalMin(value = "0.01", inclusive = false, message = "O valor total deve ser maior que zero")
    private BigDecimal valorTotal;

    @NotBlank(message = "A data da venda é obrigatória")
    private LocalDateTime dataVenda;

    @NotBlank(message = "O status da venda é obrigatório")
    @Pattern(regexp = "^(CONCLUIDA|PENDENTE|CANCELADA)$", message = "Status invalido. Deve ser CONCLUIDA, PENDENTE ou CANCELADA")
    private String statusVenda;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getClienteId(){
        return clienteId;
    }

    public void setClienteId(Long clienteId){
        this.clienteId = clienteId;
    }

    public Long getProduto(){
        return produtoId;
    }

    public void setProdutoId(Long produtoId){
        this.produtoId = produtoId;
    }

    public Integer getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal(){
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal){
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataVenda(){
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda){
        this.dataVenda = dataVenda;
    }

    public String getStatusVenda(){
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda){
        this.statusVenda = statusVenda;
    }
}
