package com.example.revisao.service;

import com.example.revisao.model.EnderecoModel;
import com.example.revisao.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Listar todos os endereços
    public List<EnderecoModel> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    // Salvar endereço, verificando se o CEP já está cadastrado
    public EnderecoModel salvar(EnderecoModel enderecoModel) {
        if (enderecoRepository.findByCep(enderecoModel.getCep()).isPresent()) {
            throw new RuntimeException("CEP já cadastrado");
        }
        return enderecoRepository.save(enderecoModel);
    }

    // Atualizar endereço pelo ID
    public EnderecoModel atualizar(UUID id, EnderecoModel enderecoModel) {
        if (!enderecoRepository.existsById(id)) {
            throw new RuntimeException("Endereço não encontrado");
        }
        enderecoModel.setId(id);
        return enderecoRepository.save(enderecoModel);
    }

    // Deletar endereço pelo ID
    public void deletar(UUID id) {
        if (!enderecoRepository.existsById(id)) {
            throw new RuntimeException("Endereço não encontrado");
        }
        enderecoRepository.deleteById(id);
    }
}
