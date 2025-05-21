// package com.example.demo.service;

// import com.example.demo.Entities.Produto;
// import com.example.demo.repository.IProdutoRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class ProdutoService {

//     // @Autowired
//     // private IProdutoRepository produtoRepository;

//     // public Produto salvar(Produto produto){
//     //     return produtoRepository.save(produto);
//     // }

//     // public Produto cadastar(Produto produto) {
//     //     return produtoRepository.save(produto);
//     // }

//     // public List<Produto> listarTodos() {
//     //     return produtoRepository.findAll();
//     // }

//     // public Optional<Produto> buscarPorId(Long id){
//     //     return produtoRepository.findById(id);
//     // }
//     // public Produto atualizar(Long id, Produto novoProduto) {
//     //     return produtoRepository.findById(id)
//     //     .map(produto -> {
//     //         produto.setNome(novoProduto.getNome());
//     //         produto.setDescricao(novoProduto.getDescricao());
//     //         produto.setQuantidade(novoProduto.getQuantidade());
//     //         produto.setPrecoUnitario(novoProduto.getPrecoUnitario());
//     //         produto.setCategoria(novoProduto.getCategoria());
//     //         return produtoRepository.save(produto);
//     //     }).orElseThrow(() -> new RuntimeException("Produto não Encontrado"));
//     // }

//     // public void deletar(Long id) {
//     //     produtoRepository.deleteById(id);
//     // }
// }
