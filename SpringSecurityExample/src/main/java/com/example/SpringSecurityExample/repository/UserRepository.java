package com.example.SpringSecurityExample.repository;


import com.example.SpringSecurityExample.entity.User;
import jdk.jfr.ContentType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //@EntityGraph(attributePaths = "authorities")
    Optional<User> findUserByEmail(String email);
}
