package com.example.aula9.service;


import com.example.aula9.dto.UsuarioRequestDTO;
import com.example.aula9.dto.UsuarioResponseDTO;
import com.example.aula9.model.UsuarioModel;
import com.example.aula9.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Metodo para salvar usuario
    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO){

        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()){
             throw new IllegalArgumentException("Email ja cadastrado");
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());

        // Criptografando a senha
        usuario.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));

        return usuarioRepository.save(usuario);
        return usuario;
    }

    //Listar todos os usuarios

    public List<UsuarioResponseDTO> listarTodos(){
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioResponseDTO(u.getNome(), u.getEmail()))
                .toList();
    }
}
