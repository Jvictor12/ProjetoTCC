package io.github.jvictor12.apiestagioifba.servidor.service;

import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;
import io.github.jvictor12.apiestagioifba.servidor.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository servidorRepository;

    public Servidor findById (Long id){
        return servidorRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Servidor não encontrado");
        });
    }

    public List<Servidor> findAll(){
        return servidorRepository.findAll();
    }

    public Servidor save (Servidor servidor){
        if(servidor == null){
            throw new ValidationException("Servidor nulo");
        }

        if(validateServidor(servidor)){
            servidorRepository.save(servidor);
        }

        return servidor;
    }

    public Servidor update(Servidor servidor){
        if(servidor == null){
            throw new ValidationException("Servidor nulo");
        }

        if(!servidorRepository.existsById(servidor.getId())) {
            throw new ObjectNotFoundException("Servidor não cadastrado");
        }

        if(validateServidor(servidor)) {
            servidorRepository.save(servidor);
        }

        return servidor;
    }

    public void deleteById(Servidor servidor){
        if(!servidorRepository.existsById(servidor.getId())){
            throw new ObjectNotFoundException("Servidor não existe");
        }
        servidorRepository.delete(servidor);
    }

    public boolean validateServidor (Servidor servidor) {
        Servidor servidor_FindByNome = servidorRepository.findByNome(servidor.getNome());

        if(servidor_FindByNome != null && !servidor_FindByNome.equals(servidor)) {
            throw new ValidationException("Nome do servidor já cadastrado no sistema");
        }

        Servidor servidor_FindByTelefone = servidorRepository.findByCelular(servidor.getCelular());

        if(servidor_FindByTelefone != null && !servidor_FindByTelefone.equals(servidor)){
            throw new ValidationException("Telefone do fornecedor já cadastrado no sistema");
        }

        return true;
    }
}
