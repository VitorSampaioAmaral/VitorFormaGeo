package com.academia.controller;

import com.academia.model.Professor;
import com.academia.repository.ProfessorRepository;
import com.academia.service.ProfessorService;
import com.academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    @PostMapping
    public Professor cadastrarProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }
}

@Controller
@RequestMapping("/professor")
class ProfessorWebController {
    
    private final ProfessorService professorService;
    private final TreinoService treinoService;

    @Autowired
    public ProfessorWebController(ProfessorService professorService,
                             TreinoService treinoService) {
        this.professorService = professorService;
        this.treinoService = treinoService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("professores", professorService.findAll());
        return "professor/dashboard";
    }

    @GetMapping("/{id}")
    public String perfilProfessor(@PathVariable Long id, Model model) {
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        model.addAttribute("treinos", treinoService.findByProfessorId(id));
        return "professor/perfil";
    }
}
