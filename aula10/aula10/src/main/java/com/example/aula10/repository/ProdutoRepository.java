package com.example.aula10.repository;

import com.example.aula10.model.FuncionarioModel;
import com.example.aula10.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByLote(String lote);
}
