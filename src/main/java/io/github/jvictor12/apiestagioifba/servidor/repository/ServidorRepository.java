package io.github.jvictor12.apiestagioifba.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long>{

}
