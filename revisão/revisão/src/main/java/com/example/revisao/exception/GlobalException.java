package com.example.revisao.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity.badRequest().body(Map.of( "mensagem",erro.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(RuntimeException erro) {
        return ResponseEntity.badRequest().body(Map.of( "mensagem",erro.getMessage()));
    }
}
