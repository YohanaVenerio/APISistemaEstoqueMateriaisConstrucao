package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Venda;
import com.example.demo.dto.VendaDTO;
import com.example.demo.mapper.VendaMapper;
import com.example.demo.repository.IVendaRepository;

@Service
public class VendaService {

    @Autowired
    private IVendaRepository vendaRepository;

    @Autowired
    private VendaMapper vendaMapper;

    public List<VendaDTO> listarTodasVendas() {
        return vendaMapper.toDTOList(vendaRepository.findAll());
    }

    public VendaDTO buscarVendaPorId(Long id) {
        return vendaRepository.findById(id)
                .map(vendaMapper::toDTO)
                .orElse(null);
    }

    public VendaDTO salvarVenda(VendaDTO vendaDTO) {
        Venda venda = vendaMapper.toEntity(vendaDTO);
        return vendaMapper.toDTO(vendaRepository.save(venda));
    }

    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}