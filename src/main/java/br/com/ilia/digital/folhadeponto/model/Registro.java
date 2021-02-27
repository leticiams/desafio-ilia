package br.com.ilia.digital.folhadeponto.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {

    private Long id;
    private LocalDate dia;
    private LocalTime primeiroHorario;
    private LocalTime segundoHorario;
    private LocalTime terceiroHorario;
    private LocalTime quartoHorario;

    public Registro() {

    }

    public Registro(Long id, LocalDate dia, LocalTime primeiroHorario, LocalTime segundoHorario, LocalTime terceiroHorario, LocalTime quartoHorario) {
        this.id = id;
        this.dia = dia;
        this.primeiroHorario = primeiroHorario;
        this.segundoHorario = segundoHorario;
        this.terceiroHorario = terceiroHorario;
        this.quartoHorario = quartoHorario;
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
}
