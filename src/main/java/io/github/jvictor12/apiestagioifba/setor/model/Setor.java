package io.github.jvictor12.apiestagioifba.setor.model;

import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_setor")
public class Setor extends AbstractEntity {

    @NotEmpty (message = "{field.name.invalido}")
    private String nome;

    @NotEmpty (message = "{field.sigla.invalido}")
    private String sigla;

    @NotNull (message = "{field.ramal.invalido}")
    private Integer ramal;

    @NotEmpty (message = "{field.email.invalido}")
    private String email;
}
