package com.example.aula10.service;

import com.example.aula10.dto.FuncionarioRequestDTO;
import com.example.aula10.dto.FuncionarioResponseDTO;
import com.example.aula10.model.FuncionarioModel;
import com.example.aula10.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<FuncionarioResponseDTO> listarTodos(){
        return funcionarioRepository
                .findAll()
                .stream()
                .map(u -> new FuncionarioResponseDTO(u.getNome(), u.getEmail())).toList();
    }

    public FuncionarioModel salvarFuncionario(FuncionarioRequestDTO dto){
        funcionarioRepository.findByEmail(dto.getEmail())
                .ifPresent(u -> { throw new IllegalArgumentException("Funcionário já cadastrado"); });

        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSenha(PasswordEncoder.encode(dto.getSenha())); // criptografa a senha

        funcionarioRepository.save(funcionario);

        return funcionario;
    }

    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioRequestDTO dto){
        FuncionarioModel funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSenha(PasswordEncoder.encode(dto.getSenha()));

        funcionarioRepository.save(funcionario);

        return funcionario;
    }
    public FuncionarioModel deletarFuncionarioRetornando(Long id){
        FuncionarioModel funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        funcionarioRepository.deleteById(id);

        return funcionario;
    }
}
