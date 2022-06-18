package io.github.jvictor12.apiestagioifba.entrega.service;

import io.github.jvictor12.apiestagioifba.entrega.model.Entrega;
import io.github.jvictor12.apiestagioifba.entrega.repository.EntregaRepository;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public List<Entrega> findByEmpenho (String empenho){ return entregaRepository.findByEmpenho(empenho);}

    public Entrega findById (Long id){
        return entregaRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Entrega não encontrada");
        });
    }

    public Entrega save (Entrega entrega){
        if (entrega == null){
            throw new ValidationException("Entrega nulo");
        }

        return entregaRepository.save(entrega);
    }

    public Entrega update (Entrega entrega){
        if (entrega == null){
            throw new ValidationException("Entrega nulo");
        }

        if (!entregaRepository.existsById(entrega.getId())){
            throw new ObjectNotFoundException("Entrega não encontrada");
        }

        return entregaRepository.save(entrega);
    }

    public void deleteById (Entrega entrega){
        if (!entregaRepository.existsById(entrega.getId())){
            throw new ObjectNotFoundException("Entrega não encontrada");
        }

        entregaRepository.delete(entrega);
    }
}
