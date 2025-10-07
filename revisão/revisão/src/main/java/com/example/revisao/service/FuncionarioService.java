package com.example.revisao.service;

import com.example.revisao.model.FuncionarioModel;
import com.example.revisao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Listar todos os funcionários
    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // Salvar funcionário, verificando duplicidade de matrícula
    public FuncionarioModel salvar(FuncionarioModel funcionario) {
        if (funcionarioRepository.findByMatricula(funcionario.getMatricula()).isPresent()) {
            throw new RuntimeException("Matrícula já cadastrada");
        }
        return funcionarioRepository.save(funcionario);
    }

    // Atualizar funcionário pelo ID
    public FuncionarioModel atualizar(UUID id, FuncionarioModel funcionario) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

    // Deletar funcionário pelo ID
    public void deletar(UUID id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        funcionarioRepository.deleteById(id);
    }
}
