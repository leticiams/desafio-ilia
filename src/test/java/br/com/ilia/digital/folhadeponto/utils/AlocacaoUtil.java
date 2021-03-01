package br.com.ilia.digital.folhadeponto.utils;

import br.com.ilia.digital.folhadeponto.dto.AlocacaoDTO;
import br.com.ilia.digital.folhadeponto.model.Alocacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AlocacaoUtil {

    public static List<AlocacaoDTO> listarAlocacoesDTO(){
        List<AlocacaoDTO> alocacoesDTO = new ArrayList<>();
        alocacoesDTO.add(criarAlocacaoDTO());
        return alocacoesDTO;
    }

    public static List<Alocacao> listarAlocacoes(){
        List<Alocacao> alocacoes = new ArrayList<>();
        alocacoes.add(criarAlocacao());
        return alocacoes;
    }

    public static AlocacaoDTO criarAlocacaoDTO(){
        AlocacaoDTO alocacaoDTO = new AlocacaoDTO();
        alocacaoDTO.setId(1L);
        alocacaoDTO.setDia(LocalDate.of(2021, 02, 03));
        alocacaoDTO.setTempo("PT5H45M0S");
        alocacaoDTO.setNomeProjeto("ACME Corporation");
        return alocacaoDTO;
    }

    public static Alocacao criarAlocacao(){
        Alocacao alocacao = new Alocacao();
        alocacao.setId(1L);
        alocacao.setDia(LocalDate.of(2021, 02, 28));
        alocacao.setTempo(LocalTime.of(5,30));
        alocacao.setNomeProjeto("ACME Corporation");
        return alocacao;
    }
    public static Alocacao criarAlocacaoComOutrosDados(){
        Alocacao alocacao = new Alocacao();
        alocacao.setId(2L);
        alocacao.setDia(LocalDate.of(2021, 02, 28));
        alocacao.setTempo(LocalTime.of(4,44));
        alocacao.setNomeProjeto("Tabajara");
        return alocacao;
    }

}
