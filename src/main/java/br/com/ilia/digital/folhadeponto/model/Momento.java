package br.com.ilia.digital.folhadeponto.model;

import java.time.LocalDate;

public class Momento {

    private Long id;
    private LocalDate dataHora;

    public Momento() {

    }

    public Momento(Long id, LocalDate dataHora) {
        this.id = id;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }
}
