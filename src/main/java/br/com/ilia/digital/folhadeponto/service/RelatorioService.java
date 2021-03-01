package br.com.ilia.digital.folhadeponto.service;

import br.com.ilia.digital.folhadeponto.dto.AlocacaoDTO;
import br.com.ilia.digital.folhadeponto.dto.RelatorioDTO;
import br.com.ilia.digital.folhadeponto.model.Relatorio;
import br.com.ilia.digital.folhadeponto.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public List<Relatorio> listar() {
        return relatorioRepository.findAll();
    }

    public List<RelatorioDTO> buscarPeloMes(String mes) {
        return relatorioRepository.buscarPorMes(mes);
    }

}
