package com.spring.beefit.repository;

import com.spring.beefit.entity.ProductdetailMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailMaterialRepository extends JpaRepository<ProductdetailMaterial, Integer> {

    @Query(value = "Select e from ProductdetailMaterial  e where  e.product.id =:id")
    List<ProductdetailMaterial> getAllById(@Param("id") Integer id);


}
