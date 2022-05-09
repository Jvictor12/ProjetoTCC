package io.github.jvictor12.apiestagioifba.cobranca.service;

import io.github.jvictor12.apiestagioifba.cobranca.model.Cobranca;
import io.github.jvictor12.apiestagioifba.cobranca.repository.CobrancaRepository;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CobrancaService {

    @Autowired
    private CobrancaRepository cobrancaRepository;

    public List<Cobranca> findByEmpenho(String empenho){ return cobrancaRepository.findByEmpenho(empenho);}

    public Cobranca findById(Long id){
        return cobrancaRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Cobrança não encontrada");
        });
    }

    public Cobranca save(Cobranca cobranca){

        if(cobranca == null){
            throw new ValidationException("Cobrança nula");
        }

        cobrancaRepository.save(cobranca);

        return cobranca;
    }

    public Cobranca update(Cobranca cobranca){

        if(cobranca == null){
            throw new ValidationException("Cobrança nula");
        }

        if(!cobrancaRepository.existsById(cobranca.getId())){
            throw new ObjectNotFoundException("Cobrança nao encontrada");
        }

        cobrancaRepository.save(cobranca);

        return cobranca;
    }

    public void deleteById(Cobranca cobranca){

        if(!cobrancaRepository.existsById(cobranca.getId())){
            throw new ObjectNotFoundException("Cobrança nao encontrada");
        };

        cobrancaRepository.delete(cobranca);
    }
}
