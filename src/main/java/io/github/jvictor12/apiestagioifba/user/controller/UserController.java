package io.github.jvictor12.apiestagioifba.user.controller;


import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import io.github.jvictor12.apiestagioifba.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Facade facade;

    @GetMapping
    public ResponseEntity findAll() { return ResponseEntity.status(HttpStatus.OK).body(facade.userFindAll());}

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) { return ResponseEntity.status(HttpStatus.OK).body(facade.userFindById(id));}

    @PostMapping
    public ResponseEntity save (@RequestBody @Valid User user) {return ResponseEntity.status(HttpStatus.CREATED).body(facade.userSave(user));}

    @PutMapping ("/{id}")
    public ResponseEntity update (@RequestBody @Valid User user) {return ResponseEntity.status(HttpStatus.OK).body(facade.userUpdate(user));}
}
