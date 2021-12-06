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

    @CNPJ
    private String cnpj;

    @NotEmpty
    private String cidade;

    @NotEmpty
    private String estado;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String email;

    @NotEmpty
    private String nomeResponsavel;

    @NotNull
    private Integer avaliacao;
}