package com.example.demo.service;

import com.example.demo.Entities.Fornecedor;
import com.example.demo.repository.IFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private IFornecedorRepository fornecedorRepository;

    public Fornecedor salvar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Fornecedor atualizar(Long id, Fornecedor fornecedorAtualizado) {
        Fornecedor existente = buscarPorId(id);
        existente.setNome(fornecedorAtualizado.getNome());
        existente.setCnpj(fornecedorAtualizado.getCnpj());
        existente.setTelefone(fornecedorAtualizado.getTelefone());
        existente.setEmail(fornecedorAtualizado.getEmail());
        return fornecedorRepository.save(existente);
    }

    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
