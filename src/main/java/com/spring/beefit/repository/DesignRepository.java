package com.spring.beefit.repository;

import com.spring.beefit.entity.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignRepository extends JpaRepository<Design, Integer> {

    @Query(value = "Select e from Design e where e.status = 0 order by e.createDate desc")
    List<Design> getAll();

    @Query("Select p from Design p where p.id = :id")
    Design getById(@Param("id") Integer id);

}
