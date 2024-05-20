package com.spring.beefit.repository;

import com.spring.beefit.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "Select e from Category e where e.status = 0 order by e.createDate desc")
    List<Category> getAll();

}
