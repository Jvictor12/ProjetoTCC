package io.github.jvictor12.apiestagioifba.infraestrutura.service;

import io.github.jvictor12.apiestagioifba.fornecedor.model.Fornecedor;
import io.github.jvictor12.apiestagioifba.fornecedor.service.FornecedorService;
import io.github.jvictor12.apiestagioifba.user.model.User;
import io.github.jvictor12.apiestagioifba.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;
import io.github.jvictor12.apiestagioifba.servidor.service.ServidorService;

import java.util.List;

@Component
public class Facade {

    @Autowired
    private UserService userService;

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ServidorService servidorService;

    /***************************** User *******************************/

    public User userFindById (Long id){
        return userService.findById(id);
    }

    public List<User> userFindAll(){
        return userService.findAll();
    }

    /**************************** Fornecedor ******************************/

    public Fornecedor fornecedorFindById (Long id){
        return fornecedorService.findById(id);
    }

    public Fornecedor fornecedorUpdate(Fornecedor fornecedor){return  fornecedorService.update(fornecedor);}

    public Fornecedor fornecedorSave (Fornecedor fornecedor){
        return fornecedorService.save(fornecedor);
    }

    public List<Fornecedor> fornecedorFindAll (){
        return fornecedorService.findAll();
    }

    public void fornecedorDelete (Fornecedor fornecedor) {fornecedorService.delete(fornecedor);}


    /**************************** Servidor ******************************/

    public Servidor servidorFindById (Long id) {return servidorService.findById(id);}
}
