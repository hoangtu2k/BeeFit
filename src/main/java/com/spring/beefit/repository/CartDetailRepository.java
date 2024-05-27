package com.spring.beefit.repository;

import com.spring.beefit.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail,Integer> {
    @Query(value = "Select e from CartDetail e where e.cart.customer.id = :id")
    List<CartDetail> getCartByCustomer(@Param("id") Integer id);
    @Query(value = "Select e from CartDetail  e where e.id = :id")
    CartDetail getById(@Param("id") Integer id);
    @Query(value = "Select e.quantity from CartDetail e where e.id = :id")
    Integer getQuantityByCartDetail(@Param("id") Integer id);
}
