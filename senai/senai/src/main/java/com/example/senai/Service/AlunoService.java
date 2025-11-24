package com.example.senai.Service;


import com.example.senai.Model.AlunoModel;
import com.example.senai.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlunoService {

    @Autowired
    public AlunoRepository alunoRepository;

    public List<AlunoModel> listaAlunos() {
        return alunoRepository.findAll();
    }

    // Salvar aluno, verificando duplicidade de email
    public AlunoModel salvar(AlunoModel alunoModel) {
        // lançar erro apenas se já existir um aluno com esse email
        if (alunoRepository.findByEmail(alunoModel.getEmail()).isPresent()){
            throw new RuntimeException("Aluno com esse email já existe");
        }

        return alunoRepository.save(alunoModel);
    }

    // Atualizar aluno pelo ID
    public AlunoModel atualizar(Long id, AlunoModel alunoModel) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoModel.setId(id);
        return alunoRepository.save(alunoModel);
    }

    // Deletar aluno pelo ID
    public void deletar(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }
}
