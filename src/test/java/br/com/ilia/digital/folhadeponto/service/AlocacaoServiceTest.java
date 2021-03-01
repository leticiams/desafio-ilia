package br.com.ilia.digital.folhadeponto.service;

import br.com.ilia.digital.folhadeponto.dto.AlocacaoDTO;
import br.com.ilia.digital.folhadeponto.model.Alocacao;
import br.com.ilia.digital.folhadeponto.repository.AlocacaoRepository;
import br.com.ilia.digital.folhadeponto.utils.AlocacaoUtil;
import org.assertj.core.api.ErrorCollector;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class AlocacaoServiceTest {

    @InjectMocks
    private AlocacaoService service;

    @Mock
    private AlocacaoRepository alocacaoRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveListarTodos() throws Exception {

        List<Alocacao> alocacoes = new ArrayList<Alocacao>();
        Alocacao alocacaoUtil = AlocacaoUtil.criarAlocacao();
        Alocacao alocacaoUtilComOutrosDados = AlocacaoUtil.criarAlocacaoComOutrosDados();

        alocacoes.add(alocacaoUtil);
        alocacoes.add(alocacaoUtilComOutrosDados);

        when(alocacaoRepository.findAll()).thenReturn(alocacoes);

        List<Alocacao> listaVazia = service.listar();
        assertEquals(2, listaVazia.size());

    }

    @Test
    public void deveSalvar() {
        AlocacaoDTO alocacaoDTO = AlocacaoUtil.criarAlocacaoDTO();

        when(alocacaoRepository.save(any(Alocacao.class))).thenReturn(new Alocacao());

        Alocacao alocacaoSalva = service.salvar(alocacaoDTO);

        assertNotNull(alocacaoSalva);
    }

}
