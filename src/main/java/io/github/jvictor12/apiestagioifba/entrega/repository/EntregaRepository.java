package io.github.jvictor12.apiestagioifba.entrega.repository;

import io.github.jvictor12.apiestagioifba.entrega.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    @Query("FROM tb_entrega AS e INNER JOIN e.empenho AS n ON n.numeroEmpenho = ?1")
    public List<Entrega> findByEmpenho (String empenho);
}
