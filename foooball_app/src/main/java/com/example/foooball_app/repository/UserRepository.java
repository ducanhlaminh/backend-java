package com.example.foooball_app.repository;
import com.example.foooball_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String userName);
    boolean existsUserByUsername(String userName);
}
