package io.github.jvictor12.apiestagioifba.fornecedor.model;

import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Entity;
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
    private String fantasia;

    @CNPJ (message = "{field.cnpj.invalido}")
    private String cnpj;

    @NotEmpty (message = "{field.rua.invalido}")
    private String rua;

    @NotEmpty (message = "{field.cidade.invalido}")
    private String cidade;

    @NotEmpty (message = "{field.estado.invalido}")
    private String estado;

    @NotEmpty (message = "{field.telefone.invalido}")
    private String telefone;

    @NotEmpty (message = "{field.email.invalido}")
    private String email;

    @NotEmpty (message = "{field.nomeResponsavel.invalido}")
    private String nomeResponsavel;

    @NotNull (message = "{field.whatsapp.invalido}")
    private Boolean whatsapp;

    @NotNull (message = "{field.avaliacao.invalido}")
    private Integer avaliacao;
}