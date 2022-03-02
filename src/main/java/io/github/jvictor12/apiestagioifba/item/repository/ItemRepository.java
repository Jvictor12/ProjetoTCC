package io.github.jvictor12.apiestagioifba.item.repository;

import io.github.jvictor12.apiestagioifba.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long> {

    Item findByCatmat(Integer catmat);
}
