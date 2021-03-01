package br.com.ilia.digital.folhadeponto.resources;

import br.com.ilia.digital.folhadeponto.dto.RelatorioDTO;
import br.com.ilia.digital.folhadeponto.model.Relatorio;
import br.com.ilia.digital.folhadeponto.service.RelatorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/relatorios")
@Api(value="API REST Relatório")
@CrossOrigin(origins = "*")
public class RelatorioResource {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping
    @ApiOperation(value="Retorna uma lista de relatórios")
    public ResponseEntity<List<Relatorio>> listar() {
        relatorioService.listar();

        return ResponseEntity.status(HttpStatus.OK).body(relatorioService.listar());
    }

//    @GetMapping(value = "/mes", produces = MediaType.APPLICATION_JSON_VALUE)
    //TODO exception Relatorio nao encontrado
//    public ResponseEntity<List<RelatorioDTO>> buscarPorMes(@RequestParam String mes) {
//        return new ResponseEntity<>(new ResponseStatus<>(relatorioService.buscarPeloMes(mes), HttpStatus.OK));
//    }

}
