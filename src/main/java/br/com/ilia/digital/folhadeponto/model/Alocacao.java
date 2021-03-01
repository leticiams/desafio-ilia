package br.com.ilia.digital.folhadeponto.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "alocacao")
public class Alocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dia", nullable = false)
    private LocalDate dia;

    @Column(name = "tempo", nullable = false)
    private LocalTime tempo;

    @Column(name = "nome_projeto", nullable = true)
    private String nomeProjeto;


    public Alocacao() {

    }

    public Alocacao(Long id, LocalDate dia, LocalTime tempo, String nomeProjeto) {
        this.id = id;
        this.dia = dia;
        this.tempo = tempo;
        this.nomeProjeto = nomeProjeto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalTime tempo) {
        this.tempo = tempo;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
}
