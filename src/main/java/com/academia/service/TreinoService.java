package com.academia.service;

import com.academia.model.Treino;
import com.academia.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {
    
    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }
    
    public List<Treino> findByAlunoId(Long alunoId) {
        return treinoRepository.findByAlunoId(alunoId);
    }
    
    public List<Treino> findByProfessorId(Long professorId) {
        return treinoRepository.findByProfessorId(professorId);
    }
    
    public Treino save(Treino treino) {
        return treinoRepository.save(treino);
    }
}
