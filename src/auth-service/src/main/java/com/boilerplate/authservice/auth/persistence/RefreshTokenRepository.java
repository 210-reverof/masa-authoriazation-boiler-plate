package com.boilerplate.authservice.auth.persistence;

import com.boilerplate.authservice.auth.persistence.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    boolean existsByRefreshToken(String refreshToken);
    void deleteByRefreshToken(String refreshToken);
}
