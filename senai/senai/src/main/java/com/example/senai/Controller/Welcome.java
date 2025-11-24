package com.example.senai.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")

public class Welcome {
    @GetMapping
    public String welcome() {
        return "Bem vindo ao Senai!";
    }

}
