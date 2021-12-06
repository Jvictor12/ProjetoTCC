package io.github.jvictor12.apiestagioifba.servidor.model;


import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_servidor")
public class Servidor extends AbstractEntity {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String cargo;

    @NotEmpty
    private String setor;

    @NotEmpty
    private String email;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String foto;
}
