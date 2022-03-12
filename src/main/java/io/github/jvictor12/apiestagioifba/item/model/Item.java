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

    @NotEmpty
    private String nome;

    @NotNull
    private Integer catmat;

    @NotEmpty
    private String valorMed;

    @NotEmpty
    private String descricao;
}
