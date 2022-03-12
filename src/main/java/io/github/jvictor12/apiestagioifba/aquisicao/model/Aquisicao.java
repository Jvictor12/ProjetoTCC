package io.github.jvictor12.apiestagioifba.aquisicao.model;

import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import io.github.jvictor12.apiestagioifba.servidor.model.Servidor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_aquisicao")
public class Aquisicao extends AbstractEntity {

    private String numeroAquisicao;

    @ManyToOne
    @NotEmpty
    private Servidor servidor;

    @NotEmpty
    private String valorTotal;

    @NotEmpty
    private Integer numeroProcesso;

    @NotEmpty
    private String linkProcesso;

    @NotEmpty
    private Date data;

    @NotEmpty
    private String tipo;

    @NotEmpty
    private String modalidade;

    @NotNull
    private Integer pac;

    @NotNull
    private Boolean recExtraOrc;

    private String anotacoes;

}
