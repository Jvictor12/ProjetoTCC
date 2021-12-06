package io.github.jvictor12.apiestagioifba.servidor.controller;

import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

    @Autowired
    private Facade facade;

    @GetMapping("/{id}")
    public ResponseEntity findById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.servidorFindById(id));
    }

}
