package com.academia.service;

import com.academia.model.Aluno;
import com.academia.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    
    private final AlunoRepository repository;
    
    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }
    
    public Aluno findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
    
    public List<Aluno> findAll() {
        return repository.findAll();
    }
    
    public Aluno save(Aluno aluno) {
        return repository.save(aluno);
    }
}
