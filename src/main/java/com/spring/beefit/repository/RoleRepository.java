package com.spring.beefit.repository;

import com.spring.beefit.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "Select e from Role e where e.status = 0 order by e.createDate desc")
    List<Role> getAll();
    @Query(value = "Select e from Role e where e.status = 0 and e.name like :name")
    List<Role> searchByName(@Param("name") String name);
    @Query(value = "select e from Role e where e.id = :id")
    Role getById(@Param("id") Integer Id);

}
