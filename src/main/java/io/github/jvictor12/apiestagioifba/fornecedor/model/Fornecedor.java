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
    private String razaoSocial;

    @NotEmpty (message = "{field.fantasia.invalido}")
    private String nomeFantasia;

    @CNPJ (message = "{field.cnpj.invalido}")
    private String cnpj;

    @NotEmpty (message = "{field.endereço.invalido}")
    private String endereco;

    @NotEmpty (message = "{field.cidade.invalido}")
    private String cidade;

    @NotEmpty (message = "{field.estado.invalido}")
    private String estado;

    @NotEmpty (message = "{field.telefone.invalido}")
    private String telefoneFixo;

    @NotEmpty (message = "{field.email.invalido}")
    private String email;

    @NotEmpty (message = "{field.celular.invalido}")
    private String cel;

    @NotEmpty (message = "{field.nomeResponsavel.invalido}")
    private String nomeResponsavel;

    @NotNull (message = "{field.whatsapp.invalido}")
    private Boolean wpp;

    @NotEmpty (message = "{field.obs_open.invalido}")
    private String obsOpen;

    @NotNull (message = "{field.av_prazo.invalido}")
    private Integer avaliacaoPrazo;

    @NotNull (message = "{field.av_entrega.invalido}")
    private Integer avaliacaoEntrega;

    @NotNull (message = "{field.av_contato.invalido}")
    private Integer avaliacaoContato;

    private Integer avaliacao;

    @PrePersist
    @PreUpdate
    private void preInsercao (){
      this.avaliacao = (avaliacaoContato + avaliacaoEntrega + avaliacaoPrazo) / 3;
    }
}