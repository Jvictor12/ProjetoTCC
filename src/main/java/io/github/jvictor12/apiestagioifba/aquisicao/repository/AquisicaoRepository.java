package io.github.jvictor12.apiestagioifba.aquisicao.repository;

import io.github.jvictor12.apiestagioifba.aquisicao.model.Aquisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AquisicaoRepository extends JpaRepository<Aquisicao, Long> {

    public Aquisicao findByNprocesso(Integer processo);
}
