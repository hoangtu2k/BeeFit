package com.spring.beefit.repository;

import com.spring.beefit.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query(value = "Select e from Brand e where e.status = 0 order by e.createDate desc")
    List<Brand> getAll();

}
