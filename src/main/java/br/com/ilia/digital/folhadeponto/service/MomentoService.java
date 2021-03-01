package br.com.ilia.digital.folhadeponto.service;

import br.com.ilia.digital.folhadeponto.dto.MomentoDTO;
import br.com.ilia.digital.folhadeponto.model.Momento;
import br.com.ilia.digital.folhadeponto.repository.MomentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentoService {

    @Autowired
    private MomentoRepository momentoRepository;

    public List<Momento> listar() {
        return momentoRepository.findAll();
    }

    public Momento buscaPorId(Long id) {
        Momento momento = momentoRepository.getOne(id);
        return momento;
    }

    public Momento salvar(MomentoDTO momentoDTO) {
        //TODO Exceptions
        Momento momento = new Momento();
        //momento.setDataHora(momentoDTO.getDataHora());
        return momentoRepository.save(momento);
    }



}
