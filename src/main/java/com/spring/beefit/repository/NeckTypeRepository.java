package com.spring.beefit.repository;

import com.spring.beefit.entity.NeckType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NeckTypeRepository extends JpaRepository<NeckType, Integer> {

    @Query(value = "Select e from NeckType e where e.status = 0 order by e.createDate desc")
    List<NeckType> getAll();

}
