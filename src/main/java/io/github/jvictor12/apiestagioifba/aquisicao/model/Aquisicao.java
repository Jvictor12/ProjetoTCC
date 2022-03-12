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

    private String n_aquisicao;

    @ManyToOne
    @NotEmpty
    private Servidor servidor;

    @NotEmpty
    private String valor_total;

    @NotEmpty
    private Integer n_processo;

    @NotEmpty
    private String link_processo;

    @NotEmpty
    private Date data;

    @NotEmpty
    private String tipo;

    @NotEmpty
    private String modalidade;

    @NotNull
    private Integer pac;

    @NotNull
    private Boolean rec_extra_orc;

    private String anotacoes;

}
