package com.example.texiwithme.domain.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column()
    long user_id;

    @Column(nullable = false)
    String username;
}
