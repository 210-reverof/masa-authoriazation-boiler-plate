package com.boilerplate.userservice.user.persistence.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    male("MALE"), female("FEMALE");

    private final String label;
}
