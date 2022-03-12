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

    @NotEmpty
    private String nome;

    @NotNull
    private Boolean colic;

    @NotEmpty
    private String email;

    @NotEmpty
    private String celular;

    @NotEmpty
    private String foto;

    @ManyToOne
    private Setor setor;
}
