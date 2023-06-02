package com.example.ecommerce_apis.repository;

import com.example.ecommerce_apis.entity.Category;
import com.example.ecommerce_apis.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("DELETE FROM Category c where c.name= ?1")
    void deleteCategoryByName(String name);
    Category findByName(String name);
}
