package io.github.jvictor12.apiestagioifba.cobranca.model;

import io.github.jvictor12.apiestagioifba.empenho.model.Empenho;
import io.github.jvictor12.apiestagioifba.fornecedor.model.Fornecedor;
import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_cobranca")
public class Cobranca extends AbstractEntity {

    @NotEmpty
    private String via;

    @NotEmpty
    private String dataHora;

    @NotEmpty
    private String contato;

    @NotEmpty
    private String comprovacao;

    @NotNull
    private Boolean resposta;

    private String dataResposta;

    private String observacao;

    @ManyToOne
    @NotNull
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn (name = "empenho_id")
    private Empenho empenho;
}
