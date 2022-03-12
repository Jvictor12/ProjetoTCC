package io.github.jvictor12.apiestagioifba.infraestrutura.service;

import io.github.jvictor12.apiestagioifba.aquisicao.model.Aquisicao;
import io.github.jvictor12.apiestagioifba.aquisicao.service.AquisicaoService;
import io.github.jvictor12.apiestagioifba.fornecedor.model.Fornecedor;
import io.github.jvictor12.apiestagioifba.fornecedor.service.FornecedorService;
import io.github.jvictor12.apiestagioifba.item.model.Item;
import io.github.jvictor12.apiestagioifba.item.service.ItemService;
import io.github.jvictor12.apiestagioifba.setor.model.Setor;
import io.github.jvictor12.apiestagioifba.setor.service.SetorService;
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

    @Autowired
    private SetorService setorService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private AquisicaoService aquisicaoService;

    /***************************** User *******************************/

    public User userFindById (Long id) {return userService.findById(id);}

    public List<User> userFindAll () {return userService.findAll();}

    public User userFindByName (String name) {return userService.findByName(name);}

    public User userSave (User user) {return userService.save(user);}

    public User userUpdate (User user) {return userService.update(user);}

    public void userDelete (User user) { userService.delete(user);}

    /**************************** Fornecedor ******************************/

    public Fornecedor fornecedorFindById (Long id) {return fornecedorService.findById(id);}

    public Fornecedor fornecedorUpdate(Fornecedor fornecedor) {return  fornecedorService.update(fornecedor);}

    public Fornecedor fornecedorSave (Fornecedor fornecedor) {return fornecedorService.save(fornecedor);}

    public List<Fornecedor> fornecedorFindAll () {return fornecedorService.findAll();}

    public void fornecedorDelete (Fornecedor fornecedor) {fornecedorService.delete(fornecedor);}


    /**************************** Servidor ******************************/

    public Servidor servidorFindById (Long id) {return servidorService.findById(id);}

    public List<Servidor> servidorFindAll () {return servidorService.findAll();}

    public Servidor servidorSave (Servidor servidor) {return servidorService.save(servidor);}

    public Servidor servidorUpdate (Servidor servidor) {return servidorService.update(servidor);}

    public void servidorDelete (Servidor servidor) {servidorService.deleteById(servidor);}


    /**************************** Servidor ******************************/

    public Setor setorFindById (Long id) { return setorService.findById(id);}

    public List<Setor> setorFindAll () {return setorService.findAll();}

    public Setor setorSave (Setor setor) {return setorService.save(setor);}

    public Setor setorUpdate (Setor setor) {return setorService.update(setor);}

    public void setorDelete (Setor setor) {setorService.delete(setor);}


    /**************************** Item ******************************/

    public Item itemFindById (Long id) {return itemService.findById(id);}

    public List<Item> itemFindAll () {return itemService.findAll();}

    public Item itemUpdate (Item item) {return itemService.update(item);}

    public Item itemSave (Item item) {return itemService.save(item);}

    public void itemDelete (Item item) {itemService.deleteById(item);}

    /**************************** Aquisicao ******************************/

    public List<Aquisicao> aquisicaoFindAll () {return aquisicaoService.findAll();}

    public Aquisicao aquisicaoFindById (Long id) {return aquisicaoService.findById(id);}

    public Aquisicao aquisicaoSave (Aquisicao aquisicao) {return aquisicaoService.save(aquisicao);}

    public Aquisicao aquisicaoUpdate (Aquisicao aquisicao) {return aquisicaoService.update(aquisicao);}

    public void aquisicaoDelete (Aquisicao aquisicao) {aquisicaoService.deleteById(aquisicao);}
}
