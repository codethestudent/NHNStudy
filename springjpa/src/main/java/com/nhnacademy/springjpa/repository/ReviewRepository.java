package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Optional<Review> findReviewByReviewId(int reviewId);

    List<Review> getReviewsByUser_UserId(String userId);
}
