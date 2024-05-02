package com.example.texiwithme.domain.user.repository;

import com.example.texiwithme.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUser_id(Long user_id); // user_id 기준으로 검색

    Optional<User> findByUsername(String Username); // username 기준으로 검색
}
