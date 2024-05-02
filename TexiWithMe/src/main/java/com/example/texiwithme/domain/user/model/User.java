package com.example.texiwithme.domain.user.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue
    long user_id;

    @Column(nullable = false, length = 20)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    Grade grade;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    @ColumnDefault("'기본 이미지 구현 예정'")
    String profile;
}
