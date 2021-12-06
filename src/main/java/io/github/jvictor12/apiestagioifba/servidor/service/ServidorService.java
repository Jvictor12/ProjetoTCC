package io.github.jvictor12.apiestagioifba.servidor.service;

import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;
import io.github.jvictor12.apiestagioifba.servidor.repository.ServidorRepository;
import org.springframework.stereotype.Service;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository servidorRepository;

    public Servidor findById (Long id){
        return servidorRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Servidor não encontrado");
        });
    }

}
