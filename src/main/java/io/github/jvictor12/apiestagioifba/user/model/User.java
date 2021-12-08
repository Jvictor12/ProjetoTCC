package io.github.jvictor12.apiestagioifba.user.model;


import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_user")
public class User extends AbstractEntity {

    @NotEmpty (message = "{field.name.invalido}")
    private String name;

    @NotEmpty (message = "{field.password.invalido}")
    private String password;
}
