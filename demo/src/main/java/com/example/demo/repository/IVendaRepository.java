package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Venda;

import java.util.Optional;

@Repository
public interface IVendaRepository extends JpaRepository<Venda, Long>{

}
