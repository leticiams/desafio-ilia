package br.com.ilia.digital.folhadeponto.resources;

import br.com.ilia.digital.folhadeponto.dto.RegistroDTO;
import br.com.ilia.digital.folhadeponto.model.Registro;
import br.com.ilia.digital.folhadeponto.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/batidas")
public class RegistroResource {

    @Autowired
    private RegistroService registroService;

    @GetMapping
    public ResponseEntity<List<Registro>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(registroService.listar());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody RegistroDTO registroDTO) {
        registroService.salvar(registroDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(registroDTO.getId()).toUri();

        return new ResponseEntity(HttpStatus.CREATED);
    }

}
