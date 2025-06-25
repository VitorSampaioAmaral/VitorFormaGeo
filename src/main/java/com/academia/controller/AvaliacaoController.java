package com.academia.controller;

import com.academia.model.AvaliacaoFisica;
import com.academia.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoRepository;

    @GetMapping
    public List<AvaliacaoFisica> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    @PostMapping
    public AvaliacaoFisica cadastrarAvaliacao(@RequestBody AvaliacaoFisica avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }
}
