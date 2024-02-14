package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByCategoryId(int categoryId);

    Optional<Category> findByCategoryName(String categoryName);
}
