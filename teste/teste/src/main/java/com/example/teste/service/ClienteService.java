package com.example.teste.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste.model.ClienteModel;
import com.example.teste.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> listarTodos(){
        return clienteRepository.findAll();
    }


    public ClienteModel salvar(ClienteModel clienteModel){
       if (clienteRepository.findByEmail(clienteModel.getEmail()).isPresent()){
        throw new RuntimeException("Aluno já Cadastrado");
       }
       return clienteRepository.save(clienteModel);
    }

      public ClienteModel atualizar(UUID ID, ClienteModel clienteModel){
       if (!clienteRepository.existsById(ID)){
        throw new RuntimeException("Aluno não Encontrado"); 
       }
       clienteModel.setId(ID);
       return clienteRepository.save(clienteModel);
    }

    public void excluir(UUID ID){
        if (!clienteRepository.existsById(ID)){
            throw new RuntimeException("Aluno não Encontrado.");
        }
        clienteRepository.deleteById(ID);
    }
}
