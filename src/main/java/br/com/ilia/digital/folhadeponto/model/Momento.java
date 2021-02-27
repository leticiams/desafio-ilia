package br.com.ilia.digital.folhadeponto.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "momento")
public class Momento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_hora", nullable = false)
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
