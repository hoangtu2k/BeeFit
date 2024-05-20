package com.spring.beefit.repository;

import com.spring.beefit.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {

    @Query(value = "Select e from ProductDetail e where e.status = 0 Order by e.createDate desc")
    List<ProductDetail> getAll();

    @Query(value = "Select e from ProductDetail e where e.status = 1 Order by e.createDate desc")
    List<ProductDetail> getAll1();


}
