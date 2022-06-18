package io.github.jvictor12.apiestagioifba.cobranca.repository;

import io.github.jvictor12.apiestagioifba.cobranca.model.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {

    @Query("FROM tb_cobranca AS c INNER JOIN c.empenho AS e ON e.numeroEmpenho = ?1")
    public List<Cobranca> findByEmpenho (String empenho);
}
