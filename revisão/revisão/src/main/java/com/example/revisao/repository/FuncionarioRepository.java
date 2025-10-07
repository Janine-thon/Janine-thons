package com.example.revisao.repository;

import com.example.revisao.model.ClienteModel;
import com.example.revisao.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, UUID> {
    Optional<FuncionarioModel> findByMatricula(String matricula);
}
