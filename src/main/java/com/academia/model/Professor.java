package com.academia.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Professor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private String cref;
    private String especialidade;
    
    @OneToMany(mappedBy = "professor")
    private List<Treino> treinos;
    
    @OneToMany(mappedBy = "professor")
    private List<AvaliacaoFisica> avaliacoes;

    public List<AvaliacaoFisica> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
