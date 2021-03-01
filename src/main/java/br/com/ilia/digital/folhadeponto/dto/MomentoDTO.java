package br.com.ilia.digital.folhadeponto.dto;

import java.time.LocalDateTime;

public class MomentoDTO {

    private Long id;
    private String dataHora;

    public MomentoDTO() {
    }

    public MomentoDTO(Long id, String dataHora) {
        this.id = id;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
