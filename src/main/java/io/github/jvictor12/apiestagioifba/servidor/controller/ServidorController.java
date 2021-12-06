package io.github.jvictor12.apiestagioifba.servidor.controller;

import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

    @Autowired
    private Facade facade;

    @GetMapping("/{id}")
    public ResponseEntity findById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.servidorFindById(id));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(facade.servidorFindAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Servidor servidor){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.servidorSave(servidor));
    }
}
