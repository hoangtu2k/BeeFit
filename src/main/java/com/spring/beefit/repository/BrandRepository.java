package com.spring.beefit.repository;

import com.spring.beefit.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query(value = "Select e from Brand e where e.status = 0 order by e.createDate desc")
    List<Brand> getAll();

}
