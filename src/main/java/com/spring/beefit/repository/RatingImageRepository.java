package com.spring.beefit.repository;

import com.spring.beefit.entity.RatingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingImageRepository extends JpaRepository<RatingImage,Integer> {
}
