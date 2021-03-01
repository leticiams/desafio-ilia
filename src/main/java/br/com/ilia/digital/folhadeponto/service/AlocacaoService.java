package br.com.ilia.digital.folhadeponto.service;

import br.com.ilia.digital.folhadeponto.dto.AlocacaoDTO;
import br.com.ilia.digital.folhadeponto.dto.RegistroDTO;
import br.com.ilia.digital.folhadeponto.exceptionhandler.AlocacaoNotFoundException;
import br.com.ilia.digital.folhadeponto.exceptionhandler.AlocadoTempoMaiorException;
import br.com.ilia.digital.folhadeponto.exceptionhandler.MethodArgumentNotValidException;
import br.com.ilia.digital.folhadeponto.model.Alocacao;
import br.com.ilia.digital.folhadeponto.model.Registro;
import br.com.ilia.digital.folhadeponto.repository.AlocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AlocacaoService {

    @Autowired
    private AlocacaoRepository alocacaoRepository;

    @Autowired
    private RegistroService registroService;

    private RegistroDTO registroDTO = new RegistroDTO();


    public List<Alocacao> listar() {
        return alocacaoRepository.findAll();
    }

    public Alocacao buscaPorId(Long id) {
        Alocacao alocacao = alocacaoRepository.getOne(id);
        naoExiste(alocacao);

        return alocacao;
    }

    private void naoExiste(Alocacao alocacao) {
        if (alocacao == null) {
            throw new AlocacaoNotFoundException();
        }
    }

    public Alocacao salvar(AlocacaoDTO alocacaoDTO) {

        Alocacao alocacao = new Alocacao();
        alocacao.setDia(alocacaoDTO.getDia());
        alocacao.setTempo(formatTempo(alocacaoDTO));
        alocacao.setNomeProjeto(alocacaoDTO.getNomeProjeto());

        validaCampos(alocacaoDTO);

        return alocacaoRepository.save(alocacao);
    }

    private void validaCampos(AlocacaoDTO alocacaoDTO) {
        if (alocacaoDTO.getDia() == null || formatTempo(alocacaoDTO) == null || alocacaoDTO.getNomeProjeto() == null ) {
            throw new MethodArgumentNotValidException();
        }
    }

    private LocalTime formatTempo(AlocacaoDTO alocacaoDTO) {
        String horaParaFomatar = alocacaoDTO.getTempo().replaceAll("[PTHMS]", "");
        DateTimeFormatter parserHora= DateTimeFormatter.ofPattern("HHmmss");
        LocalTime horaFormatada = LocalTime.parse(ajustaHora(horaParaFomatar), parserHora);

        return horaFormatada;
    }

    private String ajustaHora(String horaParaFomatar) {
        String horaFormatada = 0 + horaParaFomatar + 0;

        return horaFormatada;
    }

    private void comparaHorasTrabalhadas(AlocacaoDTO alocacaoDTO) {
        double horaTrabalhada = registroService.totalHorasTrabalhadas(registroDTO).getHour();
        double horaAlocada = formatTempo(alocacaoDTO).getHour();

        if(horaAlocada>horaTrabalhada){
            throw new AlocadoTempoMaiorException();
        }

    }


}
