package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Produto;
import com.example.demo.dto.ProdutoDTO;
import com.example.demo.mapper.CompraMapper;
import com.example.demo.mapper.FornecedorMapper;
import com.example.demo.mapper.ProdutoMapper;
import com.example.demo.repository.ICategoriaRepository;
import com.example.demo.repository.IProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Autowired
    private CompraMapper compraMapper;

    @Autowired
    private FornecedorMapper fornecedorMapper;

    public List<ProdutoDTO> listarTodosProdutos() {
        return produtoMapper.toDTOList(produtoRepository.findAll());
    }

    public ProdutoDTO buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .map(produtoMapper::toDTO)
                .orElse(null);
    }

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
    Produto produto = produtoMapper.toEntity(produtoDTO);

    // Verifica se a categoria foi informada corretamente
    if (produtoDTO.getCategoriaId() == null || produtoDTO.getCategoriaId() == null) {
        throw new IllegalArgumentException("Categoria é obrigatória");
    }

    // Busca a categoria no banco (garante que é uma entidade persistida)
    var categoria = categoriaRepository.findById(produtoDTO.getCategoriaId())
        .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

    // Define a categoria persistida no produto
    produto.setCategoria(categoria);

    // Salva o produto
    Produto salvo = produtoRepository.save(produto);
    return produtoMapper.toDTO(salvo);
}

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}