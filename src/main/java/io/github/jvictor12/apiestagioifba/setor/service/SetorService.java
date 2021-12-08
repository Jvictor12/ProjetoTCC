package io.github.jvictor12.apiestagioifba.setor.service;

import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apiestagioifba.setor.model.Setor;
import io.github.jvictor12.apiestagioifba.setor.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    public Setor findById(Long id){
        return setorRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Setor não encontrado");
        });
    }

    public List<Setor> findAll(){return setorRepository.findAll();}

    public Setor save(Setor setor){
        if(setor == null){
            throw new ValidationException("Setor nulo");
        }

        if(validateSetor(setor)){
            setorRepository.save(setor);
        }

        return setor;
    }

    public Setor update(Setor setor){

        if(setor == null){
            throw new ValidationException("Setor nulo");
        }

        if(!setorRepository.existsById(setor.getId())){
            throw new ObjectNotFoundException("Setor não cadastrado");
        }

        if(validateSetor(setor)){
            setorRepository.save(setor);
        }

        return setor;
    }

    public void delete(Setor setor){
        if(!setorRepository.existsById(setor.getId())){
            throw new ObjectNotFoundException("Setor não encontrado");
        }

        setorRepository.delete(setor);
    }

    public boolean validateSetor (Setor setor) {
        Setor setor_findByNome = setorRepository.findByNome(setor.getNome());

        if(setor_findByNome != null && !setor_findByNome.equals(setor)) {
            throw new ValidationException("Nome do setor já cadastrado no sistema");
        }

        Setor setor_findBySigla = setorRepository.findBySigla(setor.getSigla());

        if(setor_findBySigla != null && !setor_findBySigla.equals(setor)){
            throw new ValidationException("SIGLA do setor já cadastrada no sistema");
        }

        return true;
    }
}
