package com.springsecu.mysql.repository;

import com.springsecu.mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByName(); //mark it as optional, because it can happen that there is no such name - Java8 function to handle null cases
}
