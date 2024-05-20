package com.spring.beefit.repository;

import com.spring.beefit.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    @Query(value = "Select e from Color e where e.status = 0 order by e.createDate desc")
    List<Color> getAll();

}
