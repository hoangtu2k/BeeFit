package com.spring.beefit.repository;

import com.spring.beefit.entity.HandType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HandTypeRepository extends JpaRepository<HandType, Integer> {

    @Query(value = "Select e from HandType e where e.status = 0 order by e.createDate desc")
    List<HandType> getAll();

}
