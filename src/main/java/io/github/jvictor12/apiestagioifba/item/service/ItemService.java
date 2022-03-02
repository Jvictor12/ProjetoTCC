package io.github.jvictor12.apiestagioifba.item.service;


import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apiestagioifba.item.model.Item;
import io.github.jvictor12.apiestagioifba.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item findById (Long id){
        return itemRepository.findById(id).orElseThrow( ()-> {
            throw new ObjectNotFoundException("Item não encontrado");
        });
    }

    public List<Item> findAll (){ return itemRepository.findAll(); }

    public Item save(Item item){
        if (item == null){
            throw new ValidationException("Item nulo");
        }

        if (validateItem(item)){
            itemRepository.save(item);
        }
        return item;
    }

    public Boolean validateItem (Item item){
        Item item_FindByCatmat = itemRepository.findByCatmat(item.getCatmat());

        if(item_FindByCatmat != null && !item_FindByCatmat.equals(item)){
            throw new ValidationException("Catmat do item ja cadastrado no sistema");
        }

        return true;
    }

    public Item update (Item item){
        if(item == null){
            throw new ValidationException ("Item nulo");
        }

        if (!itemRepository.existsById(item.getId())){
            throw new ValidationException("Item ja cadastrado no sistema");
        }

        if(validateItem(item)){
            itemRepository.save(item);
        }

        return item;
    }

    public void deleteById (Item item){
        if(!itemRepository.existsById(item.getId())){
            throw new ObjectNotFoundException("Item não existe");
        }
        itemRepository.delete(item);
    }
}
