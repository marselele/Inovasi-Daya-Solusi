package com.demo.arselCRUD.repository;

import com.demo.arselCRUD.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Query(value = "SELECT * FROM PRODUCTS WHERE id = :id", nativeQuery = true)
    Products getProductById(@Param("id") Integer id);
}
