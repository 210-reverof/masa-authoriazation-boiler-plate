package com.boilerplate.userservice.user.persistence.domain;

import com.boilerplate.userservice.global.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@SQLDelete(sql = "UPDATE user SET deleted_at = current_timestamp WHERE id = ?")
@Where(clause = "deleted_at is null")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    private Role role;

    public User(String email, String password, String nickname, Gender gender, Integer age) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.role = Role.MEMBER;
    }

    public User(String email, String password, String nickname, Gender gender, Integer age, Role role) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.role = role;
    }
}
