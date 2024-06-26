package com.spring.beefit.repository;

import com.spring.beefit.entity.HandType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HandTypeRepository extends JpaRepository<HandType, Integer> {

    @Query(value = "Select e from HandType e where e.status = 0 order by e.createDate desc")
    List<HandType> getAll();

    @Query("Select p from HandType p where p.id = :id")
    HandType getById(@Param("id") Integer id);

}
