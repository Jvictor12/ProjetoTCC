package io.github.jvictor12.apiestagioifba.entrega.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.github.jvictor12.apiestagioifba.empenho.model.Empenho;
import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "tb_entrega")
public class Entrega extends AbstractEntity {

    private String recebimentoFornecedor;

    private String entregue;

    @ManyToOne
    private Servidor servidor;

    private String dataAteste;

    @OneToOne
    @JsonBackReference
    private Empenho empenho;
}
