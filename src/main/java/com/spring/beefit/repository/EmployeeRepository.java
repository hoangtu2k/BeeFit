package com.spring.beefit.repository;

import com.spring.beefit.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String username);

    @Query(value = "select e from Employee e where e.id = :id")
    Employee getById(@Param("id") Integer Id);


}
