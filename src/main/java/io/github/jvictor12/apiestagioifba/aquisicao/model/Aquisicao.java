package io.github.jvictor12.apiestagioifba.aquisicao.model;

import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_aquisicao")
public class Aquisicao extends AbstractEntity {

    private String numeroAquisicao;

    @ManyToOne
    @NotNull (message = "{field.servidor.invalido}")
    private Servidor servidor;

    @NotEmpty (message = "{field.valorTotal.invalido}")
    private String valorTotal;

    @NotEmpty (message = "{field.numeroProcesso.invalido}")
    private String numeroProcesso;

    @NotEmpty (message = "{field.objeto.invalido}")
    private String objeto;

    private String status;

    @Column(columnDefinition = "TEXT")
    @NotEmpty (message = "{field.linkProcesso.invalido}")
    private String linkProcesso;

    private String data;

    @NotEmpty (message = "{field.tipo.invalido}")
    private String tipo;

    @NotEmpty (message = "{field.modalidade.invalido}")
    private String modalidade;

    @NotNull (message = "{field.pac.invalido}")
    private Integer pac;

    @NotNull (message = "{field.recExtraOrc.invalido}")
    private Boolean recExtraOrc;

    private String anotacoes;

    @PrePersist
    private void prePersist(){
        this.status = "Processo Iniciado na COLIC";
    }
}
