package com.spring.beefit.repository;

import com.spring.beefit.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {

    @Query(value = "Select e from Color e where e.status = 0 order by e.createDate desc")
    List<Color> getAll();
    @Query(value = "select e from Color e where e.id = :id")
    Color getById(@Param("id") Integer Id);
    @Query(value = "Select c.id from Color c\n" +
            "join ProductdetailColorSize p on p.color.id = c.id \n" +
            "join Product pd on pd.id = p.product.id \n" +
            "where pd.id = :id \n" +
            "Group by c.id")
    List<Integer> getColorByProduct(@Param("id") Integer id);


}
