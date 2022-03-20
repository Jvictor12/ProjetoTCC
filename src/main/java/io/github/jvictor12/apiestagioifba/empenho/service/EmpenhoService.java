package io.github.jvictor12.apiestagioifba.empenho.service;

import io.github.jvictor12.apiestagioifba.empenho.model.Empenho;
import io.github.jvictor12.apiestagioifba.empenho.repository.EmpenhoRepository;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpenhoService {

    @Autowired
    private EmpenhoRepository empenhoRepository;

    public List<Empenho> findByAquisicao(String aquisicao){
        return empenhoRepository.findByAquisicao(aquisicao);
    }

    public Empenho findById(Long id){

        return empenhoRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Empenho não encontrado");
        });
    }

    public Empenho save(Empenho empenho){

        if(empenho == null){
            throw new ValidationException("Empenho nulo");
        }

        //if()
        empenhoRepository.save(empenho);

        return empenho;
    }

    public Empenho update(Empenho empenho){

        if(empenho == null){
            throw new ValidationException("Empenho nulo");
        }

        if(!empenhoRepository.existsById(empenho.getId())){
            throw new ObjectNotFoundException("Empenho não encontrado");
        }

        //if()
        empenhoRepository.save(empenho);

        return empenho;
    }

    public void deleteById(Empenho empenho){

        if (!empenhoRepository.existsById(empenho.getId())){
            throw new ObjectNotFoundException("Empenho não encontrado");
        }

        empenhoRepository.delete(empenho);
    }

    //public Boolean validateEmpenho(Empenho empenho){}
}
