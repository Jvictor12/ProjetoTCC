package io.github.jvictor12.apiestagioifba.user.model;


import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_user")
public class User extends AbstractEntity {

    private String name;
    private String password;
}
