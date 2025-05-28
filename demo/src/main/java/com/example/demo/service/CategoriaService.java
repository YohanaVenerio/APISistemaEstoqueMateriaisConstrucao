package com.example.demo.service;

import com.example.demo.Entities.Categoria;
import com.example.demo.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    
    @Autowired
    private ICategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
        Categoria categoria = buscarPorId(id);
        categoria.setNome(categoriaAtualizada.getNome());
        categoria.setDescricao(categoriaAtualizada.getDescricao());
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id) {
        Categoria categoria = buscarPorId(id);
        if (categoria.getProdutos() != null && !categoria.getProdutos().isEmpty()) {
            throw new RuntimeException("Não é possível remover a categoria com produtos associados.");
        }
        categoriaRepository.deleteById(id);
    }

    public List<Categoria> listarComProdutos() {
        return categoriaRepository.findAll();
    }
}
