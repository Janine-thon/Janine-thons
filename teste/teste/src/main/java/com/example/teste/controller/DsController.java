package com.example.teste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class DsController {
    @GetMapping
    public String Deve(){
        return "Olá Dev";
    }

}
