package com.spring.beefit.repository;

import com.spring.beefit.entity.ProductdetailColorSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailColorSizeRepository extends JpaRepository<ProductdetailColorSize, Integer> {

    @Query(value = "Select e from ProductdetailColorSize  e where  e.product.id =:id")
    List<ProductdetailColorSize> getAllById(@Param("id") Integer id);


}
