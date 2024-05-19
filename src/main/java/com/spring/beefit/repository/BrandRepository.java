package com.spring.beefit.repository;


import com.spring.beefit.entity.Brand;
import com.spring.beefit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query(value = "Select e from Brand e where e.status = 0 order by e.CreateDate desc")
    List<Brand> getAll();

}
