package io.github.jvictor12.apiestagioifba.item.controller;

import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import io.github.jvictor12.apiestagioifba.item.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private Facade facade;

    @GetMapping("/{id}")
    public ResponseEntity findById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.itemFindById(id));
    }

    @GetMapping
    public ResponseEntity findAll(){ return ResponseEntity.status(HttpStatus.OK).body(facade.itemFindAll());}

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Item item){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.itemSave(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid Item item){
        return ResponseEntity.status(HttpStatus.OK).body(facade.itemUpdate(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        facade.itemDelete(facade.itemFindById(id));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
