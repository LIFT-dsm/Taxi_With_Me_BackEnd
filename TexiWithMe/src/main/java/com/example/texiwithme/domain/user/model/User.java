package com.example.texiwithme.domain.user.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue
    long userId;

    @Column(nullable = false, name = "stu_id")
    int stdId;

    @Column(nullable = false, length = 20)
    String name;

    @Column(nullable = false, length = 20)
    String username;

    @Column(nullable = false)
    String password;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    Gender gender;

    @Column(nullable = false)
    String profile;

    @Builder
    public User (int stdId, String name, String username, String password, Gender gender, String profile) {
        this.stdId = stdId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.profile = profile == null ? "기본 이미지 구현 예정" : profile;
    }
}
