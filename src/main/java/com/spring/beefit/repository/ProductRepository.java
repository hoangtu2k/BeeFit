package com.spring.beefit.repository;

import com.spring.beefit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("Select p from Product p where p.id = :id")
    Product getById(@Param("id") Integer id);

    @Query(value = "Select e from Product e where e.status = 0 Order by e.createDate desc")
    List<Product> getAll();

    @Query(value = "Select e from Product e where e.status = 1 Order by e.createDate desc")
    List<Product> getAll1();




}
