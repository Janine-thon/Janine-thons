package com.example.revisao.repository;

import com.example.revisao.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
    Optional<ClienteModel> findByEmail(String email);
}
