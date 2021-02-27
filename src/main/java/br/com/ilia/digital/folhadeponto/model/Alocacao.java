package br.com.ilia.digital.folhadeponto.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Alocacao {

    private Long id;
    private LocalDate dia;
    private LocalTime tempo;
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
