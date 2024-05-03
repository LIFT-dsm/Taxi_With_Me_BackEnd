package com.example.texiwithme.domain.user.repository;

import com.example.texiwithme.domain.user.model.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByStdIdOrUsername(int stuId, String username); // username 기준으로 검색
    Optional<User> findByUsername(String username); // username 기준으로 검색
}
