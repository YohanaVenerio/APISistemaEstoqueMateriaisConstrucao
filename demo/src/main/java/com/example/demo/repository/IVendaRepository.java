package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Venda;

import java.util.List;

@Repository
public interface IVendaRepository extends JpaRepository<Venda, Long>{
    List<Venda> findByClienteId(Long clienteId);// Método para buscar vendas por ID do cliente

}
