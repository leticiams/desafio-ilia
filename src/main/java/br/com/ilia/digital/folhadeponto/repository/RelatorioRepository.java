package br.com.ilia.digital.folhadeponto.repository;

import br.com.ilia.digital.folhadeponto.dto.RelatorioDTO;
import br.com.ilia.digital.folhadeponto.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {

    @Query("SELECT rl FROM Relatorio rl WHERE (rl.mes = :mes) " +
            "and (:horasTrabalhadas is null or :horasTrabalhadas = '' or rl.horasTrabalhadas = :horasTrabalhadas) " +
            "and (:horasExcedentes is null or :horasExcedentes = '' or rl.horasExcedentes = :horasExcedentes) " +
            "and (:horasDevidas is null or :horasDevidas = '' or rl.horasDevidas = :horasDevidas)")
    List<RelatorioDTO> buscarPorMes(@Param("mes") String mes);

}
