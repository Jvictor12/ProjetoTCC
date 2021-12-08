package io.github.jvictor12.apiestagioifba.setor.repository;

import io.github.jvictor12.apiestagioifba.setor.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

    public Setor findByNome (String nome);

    public Setor findBySigla (String sigla);

}
