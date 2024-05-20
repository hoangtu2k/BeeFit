package com.spring.beefit.repository;

import com.spring.beefit.entity.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DesignRepository extends JpaRepository<Design, Integer> {

    @Query(value = "Select e from Design e where e.status = 0 order by e.createDate desc")
    List<Design> getAll();

}
