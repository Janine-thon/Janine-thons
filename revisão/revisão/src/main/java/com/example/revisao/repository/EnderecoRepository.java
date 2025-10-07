package com.example.revisao.repository;

import com.example.revisao.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID> {
    Optional<EnderecoModel> findByCep(String cep);
}
