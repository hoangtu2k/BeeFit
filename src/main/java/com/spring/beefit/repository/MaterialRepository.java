package com.spring.beefit.repository;

import com.spring.beefit.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    @Query(value = "Select e from Material e where e.status = 0 order by e.createDate desc")
    List<Material> getAll();

}
