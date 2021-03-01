package br.com.ilia.digital.folhadeponto.service;

import br.com.ilia.digital.folhadeponto.dto.RegistroDTO;
import br.com.ilia.digital.folhadeponto.exceptionhandler.*;
import br.com.ilia.digital.folhadeponto.model.Registro;
import br.com.ilia.digital.folhadeponto.repository.RegistroRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

        naoExiste(registro);
        validaFimDeSemana(registro);
        validaNumeroBatidas(registroDTO);
        validaHoraAlmoco(registroDTO);

        return registroRepository.save(registro);
    }

    private void validaFimDeSemana(Registro registro) {
        if((registro.getDia().getDayOfWeek() == DayOfWeek.SUNDAY) || (registro.getDia().getDayOfWeek() == DayOfWeek.SATURDAY)) {
            throw new FimdeSemanaNotAllowedException();
        }
    }

    private void validaNumeroBatidas(RegistroDTO registroDTO) {
        if (registroDTO.getHorarios().size() < 4) {
            throw new IndexOutOfBoundsException();
        } else if (registroDTO.getHorarios().size() > 4) {
            throw new MaisNumerosBatidaException();
        }
    }

    private void validaHoraAlmoco(RegistroDTO registroDTO) {
        LocalTime horaAlmoco = registroDTO.getHorarios().get(2).minusHours(registroDTO.getHorarios().get(1).getHour());
        if (horaAlmoco.getHour() < 1) {
            throw new HoraAlmocoInvalidaException();
        }
    }

    private void naoExiste(Registro registro) {
        if (registro == null) {
            throw new RegistroNotFoundException();
        }
    }

    public LocalTime totalHorasTrabalhadas(RegistroDTO registroDTO) {
        LocalTime primeiroPeriodo = registroDTO.getHorarios().get(1).minusSeconds(registroDTO.getHorarios().get(0).getSecond());
        LocalTime segundoPeriodo = registroDTO.getHorarios().get(3).minusSeconds(registroDTO.getHorarios().get(2).getSecond());

        int totalSegundosTrabalhados = primeiroPeriodo.getSecond() + segundoPeriodo.getSecond();

        double horas = totalSegundosTrabalhados / 3600;
        double minutos = (totalSegundosTrabalhados % 3600) / 60;
        double segundos = totalSegundosTrabalhados % 60;

        String tempoHora = String.format("%02d:%02d:%02d", horas, minutos, segundos);

        DateTimeFormatter parserHora= DateTimeFormatter.ofPattern("HHmmss");
        LocalTime horaFormatada = LocalTime.parse(tempoHora, parserHora);

        return horaFormatada;

    }

}
