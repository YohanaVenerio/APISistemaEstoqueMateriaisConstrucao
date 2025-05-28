package com.example.demo.service;

import com.example.demo.dto.CategoriaDTO;
import com.example.demo.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    
    @Autowired
    private ICategoriaRepository categoriaRepository;

    public CategoriaDTO salvar(CategoriaDTO categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<CategoriaDTO> listarTodas() {
        return categoriaRepository.findAll();
    }

    public CategoriaDTO buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public CategoriaDTO atualizar(Long id, CategoriaDTO categoriaAtualizada) {
        CategoriaDTO categoria = buscarPorId(id);
        categoria.setNome(categoriaAtualizada.getNome());
        categoria.setDescricao(categoriaAtualizada.getDescricao());
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id) {
        CategoriaDTO categoria = buscarPorId(id);
        if (categoria.getProdutos() != null && !categoria.getProdutos().isEmpty()) {
            throw new RuntimeException("Não é possível remover a categoria com produtos associados.");
        }
        categoriaRepository.deleteById(id);
    }

    public List<CategoriaDTO> listarComProdutos() {
        return categoriaRepository.findAll();
    }
}
