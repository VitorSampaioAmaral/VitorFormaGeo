package com.academia.controller;

import com.academia.model.Aluno;
import com.academia.model.Treino;
import com.academia.model.AvaliacaoFisica;
import com.academia.repository.AlunoRepository;
import com.academia.repository.TreinoRepository;
import com.academia.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/painel/alunos")
public class AlunoPainelController {

    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private TreinoRepository treinoRepository;
    
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoRepository;

    @GetMapping("/{id}")
    public String painelAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        List<Treino> treinos = treinoRepository.findByAlunoId(aluno.getId());
        List<AvaliacaoFisica> avaliacoes = avaliacaoRepository.findByAlunoId(aluno.getId());
        
        // Logs de depuração
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Treinos encontrados: " + treinos.size());
        System.out.println("Avaliações encontradas: " + avaliacoes.size());
        if(!avaliacoes.isEmpty()) {
            System.out.println("Primeira avaliação - Data: " + avaliacoes.get(0).getData());
            System.out.println("Primeira avaliação - DataFormatada: " + avaliacoes.get(0).getDataFormatada());
        }
        
        model.addAttribute("aluno", aluno);
        model.addAttribute("treinos", treinos);
        model.addAttribute("avaliacoes", avaliacoes);
        
        return "aluno/painel";
    }
}
