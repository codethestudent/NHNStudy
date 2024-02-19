package com.nhnacademy.edu.springboot.studentmanagement.repository;

import com.nhnacademy.edu.springboot.studentmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
