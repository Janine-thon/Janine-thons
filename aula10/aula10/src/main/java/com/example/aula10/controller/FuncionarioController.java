package com.example.aula10.controller;


import com.example.aula10.dto.FuncionarioRequestDTO;
import com.example.aula10.dto.FuncionarioResponseDTO;
import com.example.aula10.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listar(){
        return ResponseEntity.ok().body(funcionarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody FuncionarioRequestDTO dto){
        funcionarioService.salvarFuncionario(dto);
        return ResponseEntity.ok().body(Map.of("mensagem", "Funcionário cadastrado com sucesso"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar (@Valid @RequestBody FuncionarioRequestDTO dto, @PathVariable Long id){
        funcionarioService.atualizarFuncionario(id, dto);
        return ResponseEntity.ok().body(Map.of("mensagem", "Funcionário atualizado com sucesso","sucesso", true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        funcionarioService.deletarFuncionarioRetornando(id);
        return ResponseEntity.ok().body(Map.of("mensagem", "Funcionário deletado com sucesso","sucesso", true));
    }
}
