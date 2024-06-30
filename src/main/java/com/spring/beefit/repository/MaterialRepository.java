package com.spring.beefit.repository;

import com.spring.beefit.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    @Query(value = "Select e from Material e where e.status = 0 order by e.createDate desc")
    List<Material> getAll();

    @Query("Select m from Material m where m.id = :id")
    Material getById(@Param("id") Integer id);

    @Query(value = "Select cl.id from Material cl\n" +
            "join ProductdetailMaterial p on p.material.id = cl.id \n" +
            "join Product pd on pd.id = p.product.id \n" +
            "where pd.id = :id \n" +
            "Group by cl.id")
    List<Integer> getMaterialByProduct(@Param("id") Integer id);

}
