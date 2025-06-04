package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Categoria;
import com.example.demo.dto.CategoriaDTO;
import com.example.demo.mapper.CategoriaMapper;
import com.example.demo.repository.ICategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> listarTodos() {
        return categoriaMapper.toDTOList(categoriaRepository.findAll());
    }

    public CategoriaDTO buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(categoriaMapper::toDTO)
                .orElse(null);
    }

    public CategoriaDTO salvar(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        return categoriaMapper.toDTO(categoriaRepository.save(categoria));
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
