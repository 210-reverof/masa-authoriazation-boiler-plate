package com.boilerplate.userservice.user.persistence;

import com.boilerplate.userservice.user.persistence.UserRepository;
import com.boilerplate.userservice.user.persistence.domain.Gender;
import com.boilerplate.userservice.user.persistence.domain.Role;
import com.boilerplate.userservice.user.persistence.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private User user;
    private User admin;

    @BeforeEach
    public void setUp() {
        user = new User(
                "test@test.com",
                "hashedPassword",
                "testnickname",
                Gender.FEMALE,
                25
        );

        admin = new User(
                "testadmin@test.com",
                "hashedPassword",
                "admin",
                Gender.FEMALE,
                25,
                Role.ADMIN
        );
    }

    @Test
    @DisplayName("회원을 추가한다.")
    public void 회원을_추가한다() {
        // given

        // when
        userRepository.save(user);

        // then
        User savedUser = userRepository.findByEmail("test@test.com").orElse(null);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(savedUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(savedUser.getNickname()).isEqualTo(user.getNickname());
        assertThat(savedUser.getGender()).isEqualTo(user.getGender());
        assertThat(savedUser.getAge()).isEqualTo(user.getAge());
    }

    @Test
    @DisplayName("관리자를 추가한다.")
    public void 관리자를_추가한다() {
        // given

        // when
        userRepository.save(admin);

        // then
        User savedAdmin = userRepository.findByEmail("testadmin@test.com").orElse(null);

        assertThat(savedAdmin).isNotNull();
        assertThat(savedAdmin.getEmail()).isEqualTo(admin.getEmail());
        assertThat(savedAdmin.getPassword()).isEqualTo(admin.getPassword());
        assertThat(savedAdmin.getNickname()).isEqualTo(admin.getNickname());
        assertThat(savedAdmin.getGender()).isEqualTo(admin.getGender());
        assertThat(savedAdmin.getAge()).isEqualTo(admin.getAge());
        assertThat(savedAdmin.getRole()).isEqualTo(admin.getRole());
    }


}