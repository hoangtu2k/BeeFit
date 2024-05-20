package com.spring.beefit.repository;

import com.spring.beefit.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size, Integer> {

    @Query(value = "Select e from Size e where e.status = 0 order by e.createDate desc")
    List<Size> getAll();

}
