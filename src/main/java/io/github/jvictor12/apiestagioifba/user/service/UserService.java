package io.github.jvictor12.apiestagioifba.user.service;

import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ValidationException;
import io.github.jvictor12.apiestagioifba.user.model.User;
import io.github.jvictor12.apiestagioifba.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Usuário não encontrado");
        });
    }

    public User findByName (String name){
        return userRepository.findByName(name).orElseThrow(()-> {
            throw new ObjectNotFoundException("Usuario não encontrado");
        });
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user){

        if(user == null){
            throw new ValidationException("Usuario nulo");
        }

        if(validationUser(user)){
            userRepository.save(user);
        }

        return user;
    }

    public boolean validationUser(User user){
        User user_findByName = userRepository.findByName(user.getName()).orElse(null);

        if(user_findByName != null && !user_findByName.equals(user)){
            throw new ValidationException("Usuario ja cadastrado");
        }

        return true;
    }
}
