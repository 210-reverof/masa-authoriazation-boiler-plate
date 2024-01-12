package com.boilerplate.userservice.user.presentation;

import com.boilerplate.userservice.user.application.UserService;
import com.boilerplate.userservice.user.dto.request.UserJoinRequest;
import com.boilerplate.userservice.user.dto.response.UserInfoResponse;
import com.boilerplate.userservice.user.persistence.domain.Gender;
import com.boilerplate.userservice.user.persistence.domain.Role;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("회원 가입 요청을 한다")
    public void 회원가입_요청을_한다() throws Exception {
        // given
        UserJoinRequest userJoinRequest = new UserJoinRequest(
                "test@example.com", "password123", "testUser", "MALE", 25
        );
        doNothing().when(userService).join(any(UserJoinRequest.class));

        // when
        mockMvc.perform(post("/user/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userJoinRequest)))
                .andExpect(status().isOk());

        // then
        verify(userService, times(1)).join(any(UserJoinRequest.class));
    }

    @Test
    @DisplayName("사용자 정보를 가져온다")
    public void 사용자_정보를_가져온다() throws Exception {
        // given
        Long userId = 1L;
        UserInfoResponse userInfoResponse = new UserInfoResponse(1L, "test@example.com", "testUser", Gender.MALE, 25, Role.MEMBER);
        given(userService.getInfoById(userId)).willReturn(userInfoResponse);

        // when
        mockMvc.perform(get("/user/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(userInfoResponse.getEmail()))
                .andExpect(jsonPath("$.gender").value(userInfoResponse.getGender().name()))
                .andExpect(jsonPath("$.age").value(userInfoResponse.getAge()));

        // then
        verify(userService, times(1)).getInfoById(userId);
    }


    private String asJsonString(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
