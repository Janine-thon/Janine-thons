package com.example.senai.Exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
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
