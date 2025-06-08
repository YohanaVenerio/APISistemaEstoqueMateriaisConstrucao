package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Compra;
import com.example.demo.Entities.Compra.StatusCompra;
import com.example.demo.Entities.Fornecedor;
import com.example.demo.Entities.Produto;
import com.example.demo.dto.CompraDTO;
import com.example.demo.dto.FornecedorDTO;
import com.example.demo.dto.ProdutoDTO;
import com.example.demo.mapper.CompraMapper;
import com.example.demo.mapper.FornecedorMapper;
import com.example.demo.mapper.ProdutoMapper;
import com.example.demo.repository.ICompraRepository;
import com.example.demo.repository.IFornecedorRepository;
import com.example.demo.repository.IProdutoRepository;

@Service
public class CompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Autowired
    private IFornecedorRepository fornecedorRepository;

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private CompraMapper compraMapper;

    @Autowired
    private FornecedorMapper fornecedorMapper;

    @Autowired
    private ProdutoMapper produtoMapper;

    public List<CompraDTO> listarTodasCompras() {
        return compraMapper.toDTOList(compraRepository.findAll());
    }

    public CompraDTO buscarCompraPorId(Long id) {
        return compraRepository.findById(id)
                .map(compraMapper::toDTO)
                .orElse(null);
    }

    public CompraDTO salvarCompra(CompraDTO compraDTO) {
        Compra compra = new Compra();

        Fornecedor fornecedor = fornecedorRepository.findById(compraDTO.getFornecedorId())
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        
        Produto produto = produtoRepository.findById(compraDTO.getProdutoId())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        compra.setFornecedor(fornecedor);
        compra.setProduto(produto);
        compra.setQuantidade(compraDTO.getQuantidade());
        compra.setValorTotal(compraDTO.getValorTotal());
        compra.setDataCompra(compraDTO.getDataCompra());

        if (compraDTO.getStatusCompra() != null) {
            compra.setStatusCompra((compraDTO.getStatusCompra()));
        } else {
            compra.setStatusCompra(StatusCompra.PENDENTE);
        }

        return compraMapper.toDTO(compraRepository.save(compra));
    }


    public void deletarCompra(Long id) {
        compraRepository.deleteById(id);
    }

    public List<FornecedorDTO> listarTodosFornecedores() {
        return fornecedorMapper.toDTOList(fornecedorRepository.findAll());
    }

    public FornecedorDTO buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id)
                .map(fornecedorMapper::toDTO)
                .orElse(null);
    }

    public FornecedorDTO salvarFornecedor(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorDTO);
        return fornecedorMapper.toDTO(fornecedorRepository.save(fornecedor));
    }

    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

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
        return produtoMapper.toDTO(produtoRepository.save(produto));
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}