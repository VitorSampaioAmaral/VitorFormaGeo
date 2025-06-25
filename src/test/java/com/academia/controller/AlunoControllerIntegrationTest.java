package com.academia.controller;

import com.academia.model.Aluno;
import com.academia.repository.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AlunoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void testGetAlunoById() throws Exception {
        // Dado que existe um aluno cadastrado (carregado pelo DataLoader)
        Aluno aluno = alunoRepository.findAll().get(0);

        // Quando fazemos uma requisição GET para /alunos/{id}
        // Então esperamos:
        mockMvc.perform(get("/alunos/" + aluno.getId()))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.nome").value("João da Silva"));
    }

    @Test
    public void testListarTodosAlunos() throws Exception {
        mockMvc.perform(get("/alunos"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].nome").exists());
    }

    @Test
    public void testGetTreinosDoAluno() throws Exception {
        Aluno aluno = alunoRepository.findAll().get(0);
        
        mockMvc.perform(get("/alunos/" + aluno.getId() + "/treinos"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].nome").value("Treino A"));
    }

    @Test
    public void testGetAvaliacoesDoAluno() throws Exception {
        Aluno aluno = alunoRepository.findAll().get(0);
        
        mockMvc.perform(get("/alunos/" + aluno.getId() + "/avaliacoes"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].peso").value(70.5));
    }

    @Test
    public void testAgendarAvaliacao() throws Exception {
        Aluno aluno = alunoRepository.findAll().get(0);
        
        String novaAvaliacao = "{\"data\":\"2025-07-01\",\"tipo\":\"PERIODICA\"}";
        
        mockMvc.perform(post("/alunos/" + aluno.getId() + "/avaliacoes/agendar")
               .contentType("application/json")
               .content(novaAvaliacao))
               .andExpect(status().isCreated());
    }
}
