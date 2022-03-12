package io.github.jvictor12.apiestagioifba.fornecedor.repository;

import io.github.jvictor12.apiestagioifba.fornecedor.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    public Fornecedor findByNomeFantasia(String fantasia);

    public Fornecedor findByCnpj(String cnpj);
}