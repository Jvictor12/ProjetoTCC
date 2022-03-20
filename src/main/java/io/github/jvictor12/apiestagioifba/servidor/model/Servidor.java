package io.github.jvictor12.apiestagioifba.servidor.model;


import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import io.github.jvictor12.apiestagioifba.setor.model.Setor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_servidor")
public class Servidor extends AbstractEntity {

    @NotEmpty (message = "{field.name.invalido}")
    private String nome;

    @NotNull (message = "{field.colic.invalido}")
    private Boolean colic;

    @NotEmpty (message = "{field.email.invalido}")
    private String email;

    @NotEmpty (message = "{field.cargo.invalido}")
    private String cargo;

    @NotEmpty (message = "{field.celular.invalido}")
    private String celular;

    @NotEmpty (message = "{field.foto.invalido}")
    private String foto;

    @ManyToOne
    @NotNull (message = "{field.setor.invalido}")
    private Setor setor;
}
