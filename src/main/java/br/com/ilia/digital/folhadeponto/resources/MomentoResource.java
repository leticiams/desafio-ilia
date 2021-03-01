package br.com.ilia.digital.folhadeponto.resources;

import br.com.ilia.digital.folhadeponto.dto.MomentoDTO;
import br.com.ilia.digital.folhadeponto.model.Momento;
import br.com.ilia.digital.folhadeponto.service.MomentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/batidas/momento")
public class MomentoResource {

    @Autowired
    private MomentoService momentoService;

    @GetMapping
    public ResponseEntity<List<Momento>> listar() {
        momentoService.listar();

        return ResponseEntity.status(HttpStatus.OK).body(momentoService.listar());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody MomentoDTO momentoDTO) {
        momentoService.salvar(momentoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(momentoDTO.getId()).toUri();

        return new ResponseEntity("Momento da batida registrado", HttpStatus.OK);
    }

}
