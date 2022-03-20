package io.github.jvictor12.apiestagioifba.empenho.model;

import io.github.jvictor12.apiestagioifba.aquisicao.model.Aquisicao;
import io.github.jvictor12.apiestagioifba.fornecedor.model.Fornecedor;
import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import io.github.jvictor12.apiestagioifba.item.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.ZoneId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_empenho")
public class Empenho extends AbstractEntity {

    @NotEmpty (message = "{field.numeroEmpenho.invalido}")
    private String numeroEmpenho;

    @Column(updatable = false)
    private LocalDate dataEmissao;

    @NotEmpty (message = "{field.valorTotalNE.invalido}")
    private String valorTotalNE;

    @NotEmpty (message = "{field.tipoEmpenho.invalido}")
    private String tipoEmpenho;

    private LocalDate dataInclusao;

    private LocalDate dataEnvio;

    @ManyToOne
    @NotNull (message = "{field.fornecedor.invalido}")
    private Fornecedor fornecedor;

    @ManyToOne
    @NotNull (message = "{field.item.invalido}")
    private Item item;

    @ManyToOne
    @NotNull (message = "{field.aquisicao.invalido}")
    private Aquisicao aquisicao;

    @PrePersist
    private void prePersist(){
        this.dataEmissao = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        this.dataInclusao = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        this.dataEnvio = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
    }
}
