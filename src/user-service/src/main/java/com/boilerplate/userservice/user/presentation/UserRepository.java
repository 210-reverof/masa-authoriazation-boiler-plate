package com.boilerplate.userservice.user.presentation;

import com.boilerplate.userservice.user.presentation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
