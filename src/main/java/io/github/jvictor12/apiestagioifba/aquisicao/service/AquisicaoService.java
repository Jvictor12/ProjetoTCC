package io.github.jvictor12.apiestagioifba.aquisicao.service;

import io.github.jvictor12.apiestagioifba.aquisicao.model.Aquisicao;
import io.github.jvictor12.apiestagioifba.aquisicao.repository.AquisicaoRepository;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AquisicaoService {

    @Autowired
    private AquisicaoRepository aquisicaoRepository;

    public List<Aquisicao> findAll(){return aquisicaoRepository.findAll();}

    public Aquisicao findById(Long id){
        return aquisicaoRepository.findById(id).orElseThrow(()->{
            throw new ObjectNotFoundException("Aquisicao não encontrada");
        });
    }

    public Aquisicao save (Aquisicao aquisicao){
        if(aquisicao == null){
            throw new ValidationException("Aquisicao nula");
        }

        if(validateAquisicao(aquisicao)){
            return aquisicaoRepository.save(aquisicao);
        }

        return aquisicao;
    }

    public Aquisicao update (Aquisicao aquisicao){
        if(aquisicao == null){
            throw new ValidationException("Aquisicao nula");
        }

        if(!aquisicaoRepository.existsById(aquisicao.getId())){
            throw new ObjectNotFoundException("Aquisicao nao existe");
        }

        if (validateAquisicao(aquisicao)){
            return aquisicaoRepository.save(aquisicao);
        }

        return aquisicao;
    }

    public void deleteById (Aquisicao aquisicao){
        if(!aquisicaoRepository.existsById(aquisicao.getId())){
            throw new ObjectNotFoundException("Aquisicao nao existe");
        }

        aquisicaoRepository.delete(aquisicao);
    }

    public Boolean validateAquisicao (Aquisicao aquisicao){
        Aquisicao aquisicao_findByNProcesso = aquisicaoRepository.findByN_processo(aquisicao.getN_processo());

        if(aquisicao_findByNProcesso != null && !aquisicao_findByNProcesso.equals(aquisicao)){
            throw new ValidationException("Numero do processo ja cadastrado no sistema");
        }

        return true;
    }
}
