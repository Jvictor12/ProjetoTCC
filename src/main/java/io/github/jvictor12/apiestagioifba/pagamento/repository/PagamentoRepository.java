package io.github.jvictor12.apiestagioifba.pagamento.repository;

import io.github.jvictor12.apiestagioifba.pagamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {
}
