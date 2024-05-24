package com.spring.beefit.repository;

import com.spring.beefit.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "Select c from Customer c where c.status = 0 Order by c.createDate desc")
    List<Customer> getAll();

    @Query(value = "Select c from Customer c where c.status = 1 Order by c.createDate desc")
    List<Customer> getAll1();

    Customer findByUsername(String username);

    @Query(value = "select e from Customer e where e.id = :id")
    Customer getById(@Param("id") Integer Id);

}
