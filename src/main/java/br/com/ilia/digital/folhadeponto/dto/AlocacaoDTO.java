package br.com.ilia.digital.folhadeponto.dto;

import br.com.ilia.digital.folhadeponto.model.Registro;

import java.time.LocalDate;

public class AlocacaoDTO {

    private Long id;
    private LocalDate dia;
    private String tempo;
    private String nomeProjeto;
    private RegistroDTO registroDTO;


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

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
}
