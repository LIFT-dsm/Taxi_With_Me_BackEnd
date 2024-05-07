package com.example.texiwithme.domain.user.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false, name = "student_id")
    private int studentId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String profile;

    protected User() {}

    @Builder
    public User(int stdId, String name, String username, String password, Gender gender, String profile) {
        this.stdId = stdId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.profile = profile.isBlank() ? "기본 이미지 구현 예정" : profile;
    }
}
