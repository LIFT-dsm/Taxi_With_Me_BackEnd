package com.example.texiwithme.domain.user.repository;

import com.example.texiwithme.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByStudentIdOrNickname(int studentId, String nickname); 
    Optional<User> findByNickname(String nickname);
    Boolean existsByStudentIdOrNickname(int studentId, String nickname);

}
