package io.github.jvictor12.apiestagioifba.infraestrutura.security.service;

import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.security.model.UserSecurity;
import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import io.github.jvictor12.apiestagioifba.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Facade facade;

    @Autowired
    public UserDetailsService(Facade facade) {
        this.facade = facade;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        try {
            User user = facade.userFindByName(name);
            return new UserSecurity(user.getId(), user.getName(), user.getPassword());
        } catch (ObjectNotFoundException ex) { }

        throw new UsernameNotFoundException("Usuário não encontrado!");
    }
}
