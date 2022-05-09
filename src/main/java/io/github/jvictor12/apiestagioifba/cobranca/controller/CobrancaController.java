package io.github.jvictor12.apiestagioifba.cobranca.controller;

import io.github.jvictor12.apiestagioifba.cobranca.model.Cobranca;
import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cobrancas")
public class CobrancaController {

    @Autowired
    private Facade facade;

    @GetMapping("/search")
    public ResponseEntity cobrancaFindByEmpenho(@RequestParam(required = false) String empenho){

        if(empenho != null){

            List<Cobranca> cobrancas = facade.cobrancaFindByEmpenho(empenho);

            if (!cobrancas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(cobrancas);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.cobrancaFindById(id));
    }

    @PostMapping
    public ResponseEntity save (@RequestBody @Valid Cobranca cobranca){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.cobrancaSave(cobranca));
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@RequestBody @Valid Cobranca cobranca){
        return ResponseEntity.status(HttpStatus.OK).body(facade.cobrancaUpdate(cobranca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        facade.cobrancaDelete(facade.cobrancaFindById(id));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
