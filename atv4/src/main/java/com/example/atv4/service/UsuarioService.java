package com.example.atv4.service;


import com.example.atv4.model.Usuario;
import com.example.atv4.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired // Faz o papel do construtor
    private UsuarioRepository usuarioRepository;

    // Consulta no banco de dados
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    //Salvar Usuario

    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Usuário já Cadastrado");
        }

        // Só executa a linha abaixo se não existir no banco de dados.
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(UUID id, Usuario usuario){
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado");
        }
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    // Deleta

    public void excluir(UUID id){
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado.");
        }
        usuarioRepository.deleteById(id);
    }


}
