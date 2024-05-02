package com.example.texiwithme.domain.user.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Grade {
    FIRST_GRADE(1),
    SECOND_GRADE(2),
    THIRD_GRADE(3);

    private final int grade;
}
