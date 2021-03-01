package br.com.ilia.digital.folhadeponto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class RegistroDTO {

    private Long id;
    private LocalDate dia;
    private LocalTime totalHoras;
    private LocalDateTime momento;
    private ArrayList<LocalTime> horarios;


    public RegistroDTO() {

    }

    public RegistroDTO(Long id, LocalDate dia, LocalTime totalHoras, LocalDateTime momento, ArrayList<LocalTime> horarios) {
        this.id = id;
        this.dia = dia;
        this.totalHoras = totalHoras;
        this.momento = momento;
        this.horarios = horarios;
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

    public LocalTime getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(LocalTime totalHoras) {
        this.totalHoras = totalHoras;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public ArrayList<LocalTime> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<LocalTime> horarios) {
        this.horarios = horarios;
    }
}
