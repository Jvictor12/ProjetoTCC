package io.github.jvictor12.apiestagioifba.fornecedor.controller;

import io.github.jvictor12.apiestagioifba.fornecedor.model.Fornecedor;
import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private Facade facade;

    @GetMapping
    public ResponseEntity findAll () {
        return ResponseEntity.status(HttpStatus.OK).body(facade.fornecedorFindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById (@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(facade.fornecedorFindById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Fornecedor fornecedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.fornecedorSave(fornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid Fornecedor fornecedor){
        return ResponseEntity.status(HttpStatus.OK).body(facade.fornecedorUpdate(fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById (@PathVariable(name = "id") Long idFornecedor) {
        facade.fornecedorDelete(facade.fornecedorFindById(idFornecedor));
        return ResponseEntity.status((HttpStatus.OK)).body(null);
    }

}