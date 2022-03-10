package io.github.jvictor12.apiestagioifba.fornecedor.service;

import io.github.jvictor12.apiestagioifba.fornecedor.model.Fornecedor;
import io.github.jvictor12.apiestagioifba.fornecedor.repository.FornecedorRepository;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor findById(Long id){
        return fornecedorRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Fornecedor não encontrado");
        });
    }

    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }

    public Fornecedor save(Fornecedor fornecedor) {

        if(fornecedor == null){
            throw new ValidationException("Fornecedor nulo");
        }

        if (validateFornecedor(fornecedor)){
            fornecedorRepository.save(fornecedor);
        }

        return fornecedor;
    }

    public Fornecedor update(Fornecedor fornecedor){

        if(fornecedor == null){
            throw new ValidationException("Fornecedor nulo");
        }

        if(!fornecedorRepository.existsById(fornecedor.getId())){
            throw new ObjectNotFoundException("Fornecedor não cadastrado");
        }

        if (validateFornecedor(fornecedor)) {
            fornecedorRepository.save(fornecedor);
        }

        return fornecedor;
    }

    public boolean validateFornecedor(Fornecedor fornecedor){

        Fornecedor fornecedor_findByNome_fantasia = fornecedorRepository.findByNomefantasia(fornecedor.getNomefantasia());

        if(fornecedor_findByNome_fantasia != null && !fornecedor_findByNome_fantasia.equals(fornecedor)) {
            throw new ValidationException("Nome do fornecedor já cadastrado no sistema");
        }

        Fornecedor fornecedor_findByCnpj = fornecedorRepository.findByCnpj(fornecedor.getCnpj());

        if(fornecedor_findByCnpj != null && !fornecedor_findByCnpj.equals(fornecedor)){
            throw new ValidationException("CNPJ do fornecedor já cadastrado no sistema");
        }

        return true;
    }

    public void delete(Fornecedor fornecedor){

        if(!fornecedorRepository.existsById(fornecedor.getId())){
            throw new ObjectNotFoundException("Fornecedor não existe");
        }
        fornecedorRepository.delete(fornecedor);
    }
}
