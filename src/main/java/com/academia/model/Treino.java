package com.academia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Treino {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    
    @ManyToOne
    private Aluno aluno;
    
    @ManyToOne
    private Professor professor;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
