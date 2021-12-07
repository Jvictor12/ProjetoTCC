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
@Entity(name = "tb_setores")
public class Setor extends AbstractEntity {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sigla;

    @NotNull
    private Integer ramal;

    @NotEmpty
    private String email;
}
