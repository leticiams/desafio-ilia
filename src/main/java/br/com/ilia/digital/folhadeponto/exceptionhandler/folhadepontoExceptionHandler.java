package br.com.ilia.digital.folhadeponto.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

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
