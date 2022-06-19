package io.github.jvictor12.apiestagioifba.empenho.controller;

import io.github.jvictor12.apiestagioifba.empenho.model.Empenho;
import io.github.jvictor12.apiestagioifba.entrega.model.Entrega;
import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empenhos")
public class EmpenhoController {

    @Autowired
    private Facade facade;

    @GetMapping("/search")
    public ResponseEntity findByAquisicao(@RequestParam(required = false) String aquisicao) {

        if(aquisicao != null){

            List<Empenho> empenhos = facade.empenhoFindByAquisicao(aquisicao);

            if (!empenhos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(empenhos);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.empenhoFindById(id));
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Empenho empenho){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.empenhoSave(empenho));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @RequestBody Empenho empenho){

        if (empenho.getDataEnvio() != null && !empenho.getDataEnvio().isEmpty()) {
            if (empenho.getEntrega() == null){
                empenho.setEntrega(new Entrega());
                Empenho empenho1 = new Empenho();
                empenho1.setId(empenho.getId());
                empenho.getEntrega().setEmpenho(empenho1);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(facade.empenhoUpdate(empenho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        facade.empenhoDelete(facade.empenhoFindById(id));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
