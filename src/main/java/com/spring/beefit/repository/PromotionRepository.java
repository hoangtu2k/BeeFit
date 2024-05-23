package com.spring.beefit.repository;

import com.spring.beefit.entity.Product;
import com.spring.beefit.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    @Query(value = "Select e from Promotion e where e.status = 0 or e.status = 1 Order by e.createDate desc")
    List<Promotion> getAll();

    @Query(value = "Select e from Promotion e where e.status = 0 Order by e.createDate desc")
    List<Promotion> getAll0();

    @Query(value = "select e from Promotion e where e.id = :id")
    Promotion getById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM Promotion WHERE EndDate >= GETDATE() AND Status = 0 Order by e.createDate desc", nativeQuery = true)
    List<Promotion> getByEndDateAll();

    @Query("Select e from Promotion  e where e.code = :code")
    Promotion getByCode(@Param("code") String code);

}
