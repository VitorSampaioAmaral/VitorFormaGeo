package com.academia.controller;

import com.academia.model.Treino;
import com.academia.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {
    @Autowired
    private TreinoRepository treinoRepository;

    @GetMapping
    public List<Treino> listarTreinos() {
        return treinoRepository.findAll();
    }

    @PostMapping
    public Treino cadastrarTreino(@RequestBody Treino treino) {
        return treinoRepository.save(treino);
    }
}
