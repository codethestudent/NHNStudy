package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
