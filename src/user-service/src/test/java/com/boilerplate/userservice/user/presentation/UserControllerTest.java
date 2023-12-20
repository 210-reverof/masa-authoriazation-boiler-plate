package com.boilerplate.userservice.user.presentation;

import com.boilerplate.userservice.user.application.UserService;
import com.boilerplate.userservice.user.dto.request.UserJoinRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("회원요청을 한다")
    public void 회원요청을_한다() {
        // Given
        UserJoinRequest userJoinRequest = new UserJoinRequest(
                "test@example.com", "password123", "testUser", "MALE", 25
        );

        // When
        ResponseEntity<Void> responseEntity = userController.join(userJoinRequest);

        // Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(userService, times(1)).join(userJoinRequest);
    }
}
