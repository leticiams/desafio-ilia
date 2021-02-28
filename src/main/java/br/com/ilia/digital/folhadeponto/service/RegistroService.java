package br.com.ilia.digital.folhadeponto.service;

import br.com.ilia.digital.folhadeponto.model.Momento;
import br.com.ilia.digital.folhadeponto.model.Registro;
import br.com.ilia.digital.folhadeponto.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public List<Registro> listar() {
        return registroRepository.findAll();
    }

    public Registro salvar(Registro registro) {
        Momento momento = new Momento();
        momento.setDataHora(LocalDateTime.now());
        registro.setMomento(momento);

        return registroRepository.save(registro);
    }

}
