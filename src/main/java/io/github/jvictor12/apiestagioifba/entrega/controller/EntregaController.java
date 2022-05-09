package io.github.jvictor12.apiestagioifba.entrega.controller;

import io.github.jvictor12.apiestagioifba.empenho.model.Empenho;
import io.github.jvictor12.apiestagioifba.entrega.model.Entrega;
import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import io.github.jvictor12.apiestagioifba.pagamento.model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private Facade facade;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(facade.entregaFindById(id));
    }

    @GetMapping("/search")
    public ResponseEntity findByAquisicao (@RequestParam(required = false) String aquisicao) {
        if(aquisicao != null){
            List<Entrega> entregas = facade.entregaFindByAquisicao(aquisicao);
            if (!entregas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(entregas);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity save (@Valid @RequestBody Entrega entrega){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.entregaSave(entrega));
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@Valid @RequestBody Entrega entrega){

        Empenho empenho = facade.empenhoFindById(entrega.getEmpenho().getId());

        if (entrega.getDataAteste() != null && !entrega.getDataAteste().isEmpty()) {
            if (empenho.getPagamento() == null){
                Empenho empenho1 = new Empenho();
                empenho1.setId(empenho.getId());
                empenho.setPagamento(new Pagamento());
                empenho.getPagamento().setEmpenho(empenho1);
                entrega.setEmpenho(empenho1);
            }
        }

        empenho.setEntrega(entrega);

        return ResponseEntity.status(HttpStatus.OK).body(facade.empenhoUpdate(empenho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        facade.entregaDelete(facade.entregaFindById(id));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
