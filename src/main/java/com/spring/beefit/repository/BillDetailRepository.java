package com.spring.beefit.repository;

import com.spring.beefit.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {

    @Query("select e from BillDetail e where e.bill.code = :code")
    List<BillDetail> getAllByBill(@Param("code") String code);

    @Query("select e from BillDetail e where e.id = :id")
    BillDetail getById(@Param("id") Integer id);


}
