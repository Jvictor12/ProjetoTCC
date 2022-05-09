package io.github.jvictor12.apiestagioifba.pagamento.repository;

import io.github.jvictor12.apiestagioifba.pagamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {

    @Query("FROM tb_pagamento AS p INNER JOIN p.empenho AS e ON e.numeroEmpenho = ?1")
    public List<Pagamento> findByAquisicao (String aquisicao);
}
