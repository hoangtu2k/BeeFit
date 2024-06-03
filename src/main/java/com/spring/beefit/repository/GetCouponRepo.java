package com.spring.beefit.repository;

import com.spring.beefit.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetCouponRepo extends JpaRepository<Coupon,Integer> {
    @Query(value = "select e from Coupon e where e.customer.id = :id")
    List<Coupon> getByCustomer(@Param("id") Integer id);
}
