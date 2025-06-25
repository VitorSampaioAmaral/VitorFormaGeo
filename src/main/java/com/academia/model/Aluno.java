package com.academia.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    
    @OneToMany(mappedBy = "aluno")
    private List<Treino> treinos;
    
    @OneToMany(mappedBy = "aluno")
    private List<AvaliacaoFisica> avaliacoes;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        // Remove caracteres não numéricos
        String cpfNumerico = cpf.replaceAll("\\D+", "");
        
        if(cpfNumerico.length() == 11) {
            this.cpf = cpf; // Mantém o formato original
        } else {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos numéricos");
        }
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public List<AvaliacaoFisica> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
