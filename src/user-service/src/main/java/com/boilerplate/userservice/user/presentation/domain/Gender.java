package com.boilerplate.userservice.user.presentation.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("male"), FEMALE("female");

    private final String label;
}
