package br.com.ilia.digital.folhadeponto.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class folhadepontoExceptionHandler extends ResponseEntityExceptionHandler  {

    Mensagem msg = new Mensagem();

    @ExceptionHandler({ AlocacaoNotFoundException.class })
    public ResponseEntity<Mensagem> handleAlocacaoNotFoundException(AlocacaoNotFoundException ex, HttpServletResponse request) {
        msg.setMensagem("Alocação não encontrada");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<Mensagem> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletResponse request) {
        msg.setMensagem("Campo obrigatório não informado");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler({ FimdeSemanaNotAllowedException.class })
    public ResponseEntity<Mensagem> handleFimdeSemanaNotAllowedException(FimdeSemanaNotAllowedException ex, HttpServletResponse request) {
        msg.setMensagem("Sábado e domingo não são permitidos como dia de trabalho");

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msg);
    }

    @ExceptionHandler({ MaisNumerosBatidaException.class })
    public ResponseEntity<Mensagem> handleMaisNumerosBatidaException(MaisNumerosBatidaException ex, HttpServletResponse request) {
        msg.setMensagem("Apenas 4 horários podem ser registrados por dia");

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msg);
    }

    @ExceptionHandler({ IndexOutOfBoundsException.class })
    public ResponseEntity<Mensagem> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex, HttpServletResponse request) {
        msg.setMensagem("Devem ser registrados 4 horários por dia");

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msg);
    }

    @ExceptionHandler({ HoraAlmocoInvalidaException.class })
    public ResponseEntity<Mensagem> handleHoraAlmocoInvalidaException(HoraAlmocoInvalidaException ex, HttpServletResponse request) {
        msg.setMensagem("Deve haver no mínimo 1 hora de almoço");

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(msg);
    }

    @ExceptionHandler({ RegistroNotFoundException.class })
    public ResponseEntity<Mensagem> handleRegistroNotFoundException(RegistroNotFoundException ex, HttpServletResponse request) {
        msg.setMensagem("Registro não encontrado");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler({ AlocadoTempoMaiorException.class })
    public ResponseEntity<Mensagem> handleAlocadoTempoMaiorException(AlocadoTempoMaiorException ex, HttpServletResponse request) {
        msg.setMensagem("Não pode alocar tempo maior que o tempo trabalhado no dia");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler({ RegistroExistenteException.class })
    public ResponseEntity<Mensagem> handleRegistroExistenteException(RegistroExistenteException ex, HttpServletResponse request) {
        msg.setMensagem("Horários já registrados");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }


    public static class Mensagem {

        private String mensagem;

        public Mensagem() {}

        public Mensagem(String mensagem) {
            this.mensagem = mensagem;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }
    }


}
