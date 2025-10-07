package com.example.revisao.controller;

import com.example.revisao.model.ClienteModel;
import com.example.revisao.model.FuncionarioModel;
import com.example.revisao.service.ClienteService;
import com.example.revisao.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // GET /funcionarios
    @GetMapping
    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    // POST /funcionarios
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionarioModel funcionarioModel) {
        funcionarioService.salvar(funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Map.of("mensagem", "Funcionário cadastrado com sucesso!")
        );
    }

    // PUT /funcionarios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable UUID id, @RequestBody FuncionarioModel funcionarioModel) {
        funcionarioService.atualizar(id, funcionarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("mensagem", "Funcionário atualizado com sucesso!")
        );
    }

    // DELETE /funcionarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable UUID id) {
        funcionarioService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("mensagem", "Funcionário excluído com sucesso!")
        );
    }
}
