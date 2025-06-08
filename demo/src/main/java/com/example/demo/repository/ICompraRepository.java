package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Compra;
import java.util.List;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Long> {
    boolean existsByFornecedorId(Long fornecedorId);

    List<Compra> findByProdutoId(Long produtoId);
}