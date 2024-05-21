package com.spring.beefit.repository;

import com.spring.beefit.entity.ProductdetailMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailMaterialRepository extends JpaRepository<ProductdetailMaterial, Integer> {


}
