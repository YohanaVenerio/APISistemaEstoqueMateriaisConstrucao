 package com.example.demo.service;

import com.example.demo.Entities.Compra;
import com.example.demo.Entities.Fornecedor;
import com.example.demo.dto.FornecedorDTO;
import com.example.demo.mapper.FornecedorMapper;
import com.example.demo.repository.IFornecedorRepository;
import com.example.demo.repository.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private IFornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorMapper fornecedorMapper;

    @Autowired
    private ICompraRepository compraRepository;


    public List<FornecedorDTO> listarTodos() {
        return fornecedorMapper.toDTOList(fornecedorRepository.findAll());
    }

    public Optional<FornecedorDTO> buscarPorId(Long id) {
        return fornecedorRepository.findById(id).map(fornecedorMapper::toDTO);
    }

    public FornecedorDTO salvar(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorDTO);
        return fornecedorMapper.toDTO(fornecedorRepository.save(fornecedor));
    }

    public void deletar(Long id) {
        if (compraRepository.existsByFornecedorId(id)) {
            throw new IllegalStateException("Não é possível excluir o fornecedor pois existem compras associadas.");
        }
        fornecedorRepository.deleteById(id);
    }

}

