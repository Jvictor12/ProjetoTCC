package io.github.jvictor12.apiestagioifba.empenho.repository;

import io.github.jvictor12.apiestagioifba.empenho.model.Empenho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpenhoRepository extends JpaRepository <Empenho, Long>{

    @Query("FROM tb_empenho AS e INNER JOIN e.aquisicao AS a ON a.numeroAquisicao = ?1")
    public List<Empenho> findByAquisicao (String aquisicao);



    public Empenho findByNumeroEmpenho (String empenho);
}
