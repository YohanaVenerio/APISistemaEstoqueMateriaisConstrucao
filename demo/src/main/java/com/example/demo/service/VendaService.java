package com.example.demo.service;

import com.example.demo.dto.VendaDTO;
import com.example.demo.repository.IVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private IVendaRepository vendaRepository;

    public VendaDTO salvar(VendaDTO venda) {

        return vendaRepository.save(venda);
    }

    public List<VendaDTO> listarTodas() {
        return vendaRepository.findAll();
    }

    public VendaDTO buscarPorId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }
}
