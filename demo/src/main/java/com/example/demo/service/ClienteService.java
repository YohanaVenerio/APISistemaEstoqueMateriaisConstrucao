package com.example.demo.service; // Verifique se o pacote está correto

import com.example.demo.Entities.Cliente;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.mapper.ClienteMapper;
import com.example.demo.repository.IClienteRepository;

import jakarta.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteDTO> listarTodos() {
        return clienteMapper.toDTOList(clienteRepository.findAll());//The method toDTOList(List<Cliente>) is undefined for the type ClienteMapperJava(67108964)
    }

    public Optional<ClienteDTO> buscarPorId(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toDTO);//The method map(Function<? super Cliente,? extends U>) in the type Optional<Cliente> is not applicable for the arguments (clienteMapper::toDTO)Java(67108979)
    }                                                                   //The type ClienteMapper does not define toDTO(Cliente) that is applicable hereJava(603979903)

    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        return clienteMapper.toDTO(clienteRepository.save(cliente));//The method toDTO(clienteRepository.save(cliente)) is undefined for the type ClienteMapperJava(67108964)
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
