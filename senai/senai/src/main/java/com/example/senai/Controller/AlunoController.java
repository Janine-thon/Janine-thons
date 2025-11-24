package com.example.senai.Controller;


import com.example.senai.Model.AlunoModel;
import com.example.senai.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {
    @Autowired
    public AlunoService alunoService;

    @GetMapping
    public List<AlunoModel> listaAlunos() {
        return alunoService.listaAlunos();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> salvar(@RequestBody AlunoModel alunoModel) {
        alunoService.salvar(alunoModel);
        return ResponseEntity.ok(Map.of("message", "Aluno salvo com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> atualizar(@RequestBody AlunoModel alunoModel, @PathVariable Long id) {
        alunoService.atualizar(id, alunoModel);
        return ResponseEntity.ok(Map.of("message", "Aluno atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.ok(Map.of("message", "Aluno deletado com sucesso"));
    }
}
