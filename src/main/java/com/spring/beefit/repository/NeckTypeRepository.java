package com.spring.beefit.repository;

import com.spring.beefit.entity.NeckType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeckTypeRepository extends JpaRepository<NeckType, Integer> {

    @Query(value = "Select e from NeckType e where e.status = 0 order by e.createDate desc")
    List<NeckType> getAll();

    @Query("Select p from NeckType p where p.id = :id")
    NeckType getById(@Param("id") Integer id);

}
