package com.boilerplate.userservice.user.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PasswordEncoderTest {
    private PasswordEncoder passwordEncoder = new SHA256PasswordEncoder();

    @Test
    @DisplayName("비밀번호를 암호화하여 일치여부를 확인한다.")
    public void 비밀번호를_암호화하여_일치여부를_확인한다() {
        // given
        String rawPassword = "testpassword";
        String wrongEncodedPassword = "wrongencodedpassword";

        // when
        String hashedPassword = passwordEncoder.encode(rawPassword);

        // then
        Assertions.assertTrue(passwordEncoder.matches(rawPassword, hashedPassword));
        Assertions.assertFalse(passwordEncoder.matches(rawPassword, wrongEncodedPassword));
    }

}