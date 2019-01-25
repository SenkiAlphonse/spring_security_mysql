package com.springsecu.mysql.repository;

import com.springsecu.mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
