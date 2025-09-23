package com.example.atividade.repository;

import com.example.atividade.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {
}
