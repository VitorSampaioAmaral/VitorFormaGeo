package com.academia.service;

import com.academia.model.AvaliacaoFisica;
import com.academia.repository.AvaliacaoFisicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    
    private final AvaliacaoFisicaRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoFisicaRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }
    
    public List<AvaliacaoFisica> findByAlunoId(Long alunoId) {
        return avaliacaoRepository.findByAlunoId(alunoId);
    }
    
    public AvaliacaoFisica save(AvaliacaoFisica avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }
}
