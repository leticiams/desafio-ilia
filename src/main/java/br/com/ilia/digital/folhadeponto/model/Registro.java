package br.com.ilia.digital.folhadeponto.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "dia", nullable = false)
    private LocalDate dia;

    @Column(name = "primeiro_horario")
    private LocalTime primeiroHorario;

    @Column(name = "segundo_horario")
    private LocalTime segundoHorario;

    @Column(name = "terceiro_horario")
    private LocalTime terceiroHorario;

    @Column(name = "quarto_horario")
    private LocalTime quartoHorario;

    @OneToOne(targetEntity = Momento.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_momento")
    private Momento momento;


    public Registro() {

    }

    public Registro(Long id, LocalDate dia, LocalTime primeiroHorario, LocalTime segundoHorario, LocalTime terceiroHorario, LocalTime quartoHorario, Momento momento) {
        this.id = id;
        this.dia = dia;
        this.primeiroHorario = primeiroHorario;
        this.segundoHorario = segundoHorario;
        this.terceiroHorario = terceiroHorario;
        this.quartoHorario = quartoHorario;
        this.momento = momento;
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

    public LocalTime getPrimeiroHorario() {
        return primeiroHorario;
    }

    public void setPrimeiroHorario(LocalTime primeiroHorario) {
        this.primeiroHorario = primeiroHorario;
    }

    public LocalTime getSegundoHorario() {
        return segundoHorario;
    }

    public void setSegundoHorario(LocalTime segundoHorario) {
        this.segundoHorario = segundoHorario;
    }

    public LocalTime getTerceiroHorario() {
        return terceiroHorario;
    }

    public void setTerceiroHorario(LocalTime terceiroHorario) {
        this.terceiroHorario = terceiroHorario;
    }

    public LocalTime getQuartoHorario() {
        return quartoHorario;
    }

    public void setQuartoHorario(LocalTime quartoHorario) {
        this.quartoHorario = quartoHorario;
    }

    public Momento getMomento() {
        return momento;
    }

    public void setMomento(Momento momento) {
        this.momento = momento;
    }
}
