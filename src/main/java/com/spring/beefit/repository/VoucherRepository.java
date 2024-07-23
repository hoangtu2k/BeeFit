package com.spring.beefit.repository;

import com.spring.beefit.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

    @Query(value = "Select e from Voucher e where e.status = 0 or e.status = 1 order by e.createDate desc")
    List<Voucher> getAll();

    @Query(value = "Select e from Voucher e where e.status = 0 order by e.createDate desc")
    List<Voucher> getAllToBill();

    @Query(value = "Select e from Voucher e where e.status = 0 or e.status = 1 and e.name like :name")
    List<Voucher> searchByName(@Param("name") String name);
    @Query(value = "select e from Voucher e where e.id = :id")
    Voucher getById(@Param("id") Integer Id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Voucher SET Status = 1 WHERE EndDate <= DATEADD(MINUTE, 1, GETDATE())\n",nativeQuery = true)
    void updateExpensive();

}
