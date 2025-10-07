package com.example.revisao.service;

import com.example.revisao.model.ClienteModel;
import com.example.revisao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos os clientes
    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll();
    }

    // Salvar cliente, com verificação de email duplicado
    public ClienteModel salvar(ClienteModel clienteModel) {
        if (clienteRepository.findByEmail(clienteModel.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        return clienteRepository.save(clienteModel);
    }

    // Atualizar cliente por ID
    public ClienteModel atualizar(UUID id, ClienteModel clienteModel) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteModel.setId(id);
        return clienteRepository.save(clienteModel);
    }

    // Deletar cliente por ID
    public void deletar(UUID id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
