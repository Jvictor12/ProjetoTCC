package io.github.jvictor12.apiestagioifba.servidor.repository;

import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long>{

    public Servidor findByNome(String nome);

    public Servidor findByCelular(String Celular);
}
