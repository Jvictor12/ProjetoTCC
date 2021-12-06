package io.github.jvictor12.apiestagioifba.servidor.model;


import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_servidor")
public class Servidor extends AbstractEntity {

    private String nome;
    private String cargo;
    private String setor;
    private String email;
    private String telefone;
    private String foto;
}
