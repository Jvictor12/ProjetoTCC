package io.github.jvictor12.apiestagioifba.pagamento.controller;

import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import io.github.jvictor12.apiestagioifba.pagamento.model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/pagamentos")
public class PagamentoController {

    @Autowired
    private Facade facade;

    @GetMapping("/search")
    public ResponseEntity findByAquisicao (@RequestParam(required = false) String aquisicao){

        if(aquisicao != null){
            List<Pagamento> pagamentos = facade.pagamentoFindByAquisiao(aquisicao);

            if(!pagamentos.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK).body(pagamentos);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento(s) não encontrado(s)");
    }

    @GetMapping("/{id}")
    public ResponseEntity findById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.pagamentoFindById(id));
    }

    @PostMapping
    public ResponseEntity save (@RequestBody @Valid Pagamento pagamento){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.pagamentoSave(pagamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@RequestBody @Valid Pagamento pagamento){
        return ResponseEntity.status(HttpStatus.OK).body(facade.pagamentoUpdate(pagamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        facade.pagamentoDelete(facade.pagamentoFindById(id));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
