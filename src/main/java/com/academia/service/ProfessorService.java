package com.academia.service;

import com.academia.model.Professor;
import com.academia.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
    
    public Professor findById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }
    
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }
}
