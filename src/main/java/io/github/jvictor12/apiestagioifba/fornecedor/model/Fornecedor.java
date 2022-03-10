package io.github.jvictor12.apiestagioifba.fornecedor.model;

import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_fornecedor")
public class Fornecedor extends AbstractEntity {

    @NotEmpty(message = "{field.razaoSocial.invalido}")
    private String razao_social;

    @NotEmpty (message = "{field.fantasia.invalido}")
    private String nomefantasia;

    @CNPJ (message = "{field.cnpj.invalido}")
    private String cnpj;

    @NotEmpty (message = "{field.endereço.invalido}")
    private String endereço;

    @NotEmpty (message = "{field.cidade.invalido}")
    private String cidade;

    @NotEmpty (message = "{field.estado.invalido}")
    private String estado;

    @NotEmpty (message = "{field.telefone.invalido}")
    private String tel_fixo;

    @NotEmpty (message = "{field.email.invalido}")
    private String email;

    @NotEmpty (message = "{field.celular.invalido}")
    private String cel;

    @NotEmpty (message = "{field.nomeResponsavel.invalido}")
    private String nome_responsavel;

    @NotNull (message = "{field.whatsapp.invalido}")
    private Boolean wpp;

    @NotEmpty (message = "{field.obs_open.invalido}")
    private String obs_open;

    @NotNull (message = "{field.av_prazo.invalido}")
    private Integer av_prazo;

    @NotNull (message = "{field.av_entrega.invalido}")
    private Integer av_entrega;

    @NotNull (message = "{field.av_contato.invalido}")
    private Integer av_contato;

    private Integer avaliacao;

    @PrePersist
    @PreUpdate
    private void preInsercao (){
      this.avaliacao = (av_contato + av_entrega + av_prazo) / 3;
    }
}