package com.academia.repository;

import com.academia.model.AvaliacaoFisica;
import com.academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
    List<AvaliacaoFisica> findByAluno(Aluno aluno);
    List<AvaliacaoFisica> findByAlunoId(Long alunoId);
}
