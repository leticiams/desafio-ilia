package br.com.ilia.digital.folhadeponto.model;

import javax.persistence.*;

@Entity
@Table(name = "relatorio")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mes", nullable = true)
    private String mes;

    @Column(name = "horas_trabalhadas", nullable = true)
    private String horasTrabalhadas;

    @Column(name = "horas_excedentes", nullable = true)
    private String horasExcedentes;

    @Column(name = "horas_devidas", nullable = true)
    private String horasDevidas;


    public Relatorio() {

    }

    public Relatorio(Long id, String mes, String horasTrabalhadas, String horasExcedentes, String horasDevidas) {
        this.id = id;
        this.mes = mes;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasExcedentes = horasExcedentes;
        this.horasDevidas = horasDevidas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(String horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getHorasExcedentes() {
        return horasExcedentes;
    }

    public void setHorasExcedentes(String horasExcedentes) {
        this.horasExcedentes = horasExcedentes;
    }

    public String getHorasDevidas() {
        return horasDevidas;
    }

    public void setHorasDevidas(String horasDevidas) {
        this.horasDevidas = horasDevidas;
    }
}
