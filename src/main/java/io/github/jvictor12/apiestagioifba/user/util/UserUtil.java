package io.github.jvictor12.apiestagioifba.user.util;

import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import io.github.jvictor12.apiestagioifba.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private Facade facade;

    public User encorderPassword(User user){

        if(user.getId() != null){

            User user_findById = facade.userFindById(user.getId());

            if(user_findById != null){

                if(!user_findById.getPassword().equals(user.getPassword())){
                    user.setPassword(encoder.encode(user.getPassword()));
                }
            }
        } else {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        return user;
    }
}
