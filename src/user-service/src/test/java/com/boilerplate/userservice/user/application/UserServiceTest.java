package com.boilerplate.userservice.user.application;

import com.boilerplate.userservice.user.dto.request.UserJoinRequest;
import com.boilerplate.userservice.user.persistence.UserRepository;
import com.boilerplate.userservice.user.persistence.domain.Gender;
import com.boilerplate.userservice.user.persistence.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("회원을 추가한다.")
    void 회원을_추가한다() {
        // Given
        UserJoinRequest userJoinRequest = new UserJoinRequest(
                "test@example.com", "password123", "testuser", "male", 25
        );
        when(passwordEncoder.encode("password123")).thenReturn("hashedPassword123");

        // When
        userService.join(userJoinRequest);

        // Then
        verify(userRepository, times(1)).save(any(User.class));
    }
}