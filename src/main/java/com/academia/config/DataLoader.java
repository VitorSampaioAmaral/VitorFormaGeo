package com.academia.config;

import com.academia.model.*;
import com.academia.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(AlunoRepository alunoRepo, 
                                 ProfessorRepository professorRepo,
                                 TreinoRepository treinoRepo,
                                 AvaliacaoFisicaRepository avaliacaoRepo) {
        return args -> {
            Professor prof = new Professor();
            prof.setNome("Carlos Silva");
            prof.setCref("CREF12345");
            professorRepo.save(prof);

            Aluno aluno = new Aluno();
            aluno.setNome("João da Silva");
            aluno.setEmail("joao@email.com");
            aluno.setCpf("123.456.789-00");
            alunoRepo.save(aluno);

            Treino treino = new Treino();
            treino.setNome("Treino A");
            treino.setDescricao("Treino para iniciantes");
            treino.setAluno(aluno);
            treino.setProfessor(prof);
            treinoRepo.save(treino);

            AvaliacaoFisica avaliacao = new AvaliacaoFisica();
            avaliacao.setData(LocalDate.now());
            avaliacao.setPeso(70.5);
            avaliacao.setAltura(1.75);
            avaliacao.setAluno(aluno);
            avaliacao.setProfessor(prof);
            avaliacaoRepo.save(avaliacao);
        };
    }
}
