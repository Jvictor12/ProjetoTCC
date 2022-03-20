package io.github.jvictor12.apiestagioifba.item.model;

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
@Entity(name = "tb_item")
public class Item extends AbstractEntity {

    @NotEmpty (message = "{field.name.invalido}")
    private String nome;

    @NotNull (message = "{field.catmat.invalido}")
    private Integer catmat;

    @NotEmpty (message = "{field.valorMed.invalido}")
    private String valorMed;

    @NotEmpty (message = "{field.descricao.invalido}")
    private String descricao;
}
