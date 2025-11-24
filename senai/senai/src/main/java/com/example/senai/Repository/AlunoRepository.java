package com.example.senai.Repository;

import com.example.senai.Model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
    Optional<AlunoModel> findByEmail(String Email);
}
