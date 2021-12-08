package io.github.jvictor12.apiestagioifba.setor.controller;


import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;

import io.github.jvictor12.apiestagioifba.setor.model.Setor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private Facade facade;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.setorFindById(id));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(facade.setorFindAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Setor setor){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.setorSave(setor));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid Setor setor){
        return ResponseEntity.status(HttpStatus.OK).body(facade.setorUpdate(setor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        facade.setorDelete(facade.setorFindById(id));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
