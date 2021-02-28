package br.com.ilia.digital.folhadeponto.service;

import br.com.ilia.digital.folhadeponto.exceptionhandler.AlocacaoNotFoundException;
import br.com.ilia.digital.folhadeponto.model.Alocacao;
import br.com.ilia.digital.folhadeponto.repository.AlocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlocacaoService {

    @Autowired
    private AlocacaoRepository alocacaoRepository;

    public List<Alocacao> listar() {
        return alocacaoRepository.findAll();
    }

    public Alocacao salvar(Alocacao alocacao) {
        return alocacaoRepository.save(alocacao);
    }

    public Alocacao buscaPorId(Long id) {
        Alocacao alocacao = alocacaoRepository.getOne(id);
        naoExiste(alocacao);

        return alocacao;
    }

    private void naoExiste(Alocacao alocacao) {
        if (alocacao.getId() == null) {
            throw new AlocacaoNotFoundException();
        }
    }

}
