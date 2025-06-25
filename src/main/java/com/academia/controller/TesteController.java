package com.academia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TesteController {
    
    @GetMapping("/teste")
    @ResponseBody
    public String teste() {
        return "Funcionando!";
    }
}
