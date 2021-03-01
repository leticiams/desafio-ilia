package br.com.ilia.digital.folhadeponto.service;

import br.com.ilia.digital.folhadeponto.dto.RegistroDTO;
import br.com.ilia.digital.folhadeponto.model.Registro;
import br.com.ilia.digital.folhadeponto.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public List<Registro> listar() {
        return registroRepository.findAll();
    }

    public Registro salvar(RegistroDTO registroDTO) {
        Registro registro = new Registro();
        registro.setDia(registroDTO.getDia());
        registro.setPrimeiroHorario(registroDTO.getHorarios().get(0));
        registro.setSegundoHorario(registroDTO.getHorarios().get(1));
        registro.setTerceiroHorario(registroDTO.getHorarios().get(2));
        registro.setQuartoHorario(registroDTO.getHorarios().get(3));
        return registroRepository.save(registro);
    }

}
