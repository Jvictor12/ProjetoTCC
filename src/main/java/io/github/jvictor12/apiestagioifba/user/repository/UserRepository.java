package io.github.jvictor12.apiestagioifba.user.repository;

import io.github.jvictor12.apiestagioifba.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByName(String name);
}
