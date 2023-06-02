package com.example.ecommerce_apis.repository;

import com.example.ecommerce_apis.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p from Product p where p.category.id = ?1")
    List<Product> findByCategory(Long id);
    @Query("SELECT p from Product p where p.price >= ?1 and p.price <= ?2")
    List<Product> findByPriceRange(Double lowRange, Double highRange);
    @Query("SELECT p from Product p where p.category.id = ?1 and (p.price >= ?2 and p.price <= ?3)")
    List<Product> findByCategoryAndPriceRange(Long id, Double lowPrice, Double highPrice);
    List<Product> findProductsByCategory_Id(Long id);
}
