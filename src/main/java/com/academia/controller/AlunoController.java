package com.academia.controller;

import com.academia.model.Aluno;
import com.academia.model.Treino;
import com.academia.model.AvaliacaoFisica;
import com.academia.service.AlunoService;
import com.academia.service.TreinoService;
import com.academia.service.AvaliacaoService;
import com.academia.dto.AlunoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    private final AlunoService alunoService;
    private final TreinoService treinoService;
    private final AvaliacaoService avaliacaoService;

    public AlunoController(AlunoService alunoService,
                         TreinoService treinoService,
                         AvaliacaoService avaliacaoService) {
        this.alunoService = alunoService;
        this.treinoService = treinoService;
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoService.findAll());
        return "aluno/lista";
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> painelAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.findById(id);
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setCpf(aluno.getCpf());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/novo")
    public String formNovoAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/form";
    }

    @PostMapping
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/alunos";
    }
}
