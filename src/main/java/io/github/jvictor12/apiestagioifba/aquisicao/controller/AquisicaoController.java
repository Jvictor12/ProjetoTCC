package io.github.jvictor12.apiestagioifba.aquisicao.controller;

import io.github.jvictor12.apiestagioifba.aquisicao.model.Aquisicao;
import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/aquisicoes")
public class AquisicaoController {

    @Autowired
    private Facade facade;

    @GetMapping
    public ResponseEntity findAll() {return ResponseEntity.status(HttpStatus.OK).body(facade.aquisicaoFindAll());}

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(facade.aquisicaoFindById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid Aquisicao aquisicao){
        return ResponseEntity.status(HttpStatus.OK).body(facade.aquisicaoUpdate(aquisicao));
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Aquisicao aquisicao){
        facade.aquisicaoSave(aquisicao);
        aquisicao.setN_aquisicao(aquisicao.getId() + "-" + LocalDate.now().getYear());
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.aquisicaoUpdate(aquisicao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        facade.aquisicaoDelete(facade.aquisicaoFindById(id));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
