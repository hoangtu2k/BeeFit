package com.spring.beefit.repository;

import com.spring.beefit.entity.ProductdetailColorSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailColorSizeRepository extends JpaRepository<ProductdetailColorSize, Integer> {


}
