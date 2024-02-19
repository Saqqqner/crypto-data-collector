package ru.adel.cryptodatacollector.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.adel.cryptodatacollector.model.core.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
