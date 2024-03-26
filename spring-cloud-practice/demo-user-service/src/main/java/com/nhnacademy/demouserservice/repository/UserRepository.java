package com.nhnacademy.demouserservice.repository;

import com.nhnacademy.demouserservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
