package br.com.ilia.digital.folhadeponto.resources;

import br.com.ilia.digital.folhadeponto.dto.AlocacaoDTO;
import br.com.ilia.digital.folhadeponto.model.Alocacao;
import br.com.ilia.digital.folhadeponto.service.AlocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/alocacoes")
public class AlocacaoResource {

    @Autowired
    private AlocacaoService alocacaoService;

    @GetMapping
    public ResponseEntity<List<Alocacao>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(alocacaoService.listar());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody AlocacaoDTO alocacaoDTO) {
        alocacaoService.salvar(alocacaoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alocacaoDTO.getId()).toUri();

        return new ResponseEntity("Horas alocadas ao projeto", HttpStatus.CREATED);
    }

}
