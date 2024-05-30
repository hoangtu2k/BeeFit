package com.spring.beefit.repository;

import com.spring.beefit.entity.BillHistory;
import com.spring.beefit.viewmodel.response.BillHistoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillHistoryRepository extends JpaRepository<BillHistory,Integer> {

    @Query(value = "Select e.CreateDate, e.CreateBy, e.Note, e.Status from BillHistory e " +
            "join Bill b on b.Id = e.IdOrder where b.Code = :code order by e.CreateDate asc",nativeQuery = true)
    List<BillHistoryResponse> getAllByBill(@Param("code") String code);

    @Query(value = "Select e.CreateDate, e.CreateBy, e.Note, e.Status from BillHistory e " +
            "join Bill b on b.Id = e.IdOrder where b.Code = :code order by e.CreateDate desc",nativeQuery = true)
    List<BillHistoryResponse> getAllByBill1(@Param("code") String code);

    @Query(value = "select e from BillHistory e where e.bill.code = :code")
    List<BillHistory> getAllByBillCode(@Param("code") String code);
}
