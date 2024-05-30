package com.spring.beefit.service;

import com.spring.beefit.entity.Customer;
import com.spring.beefit.entity.Product;
import com.spring.beefit.entity.Rating;
import com.spring.beefit.entity.RatingImage;
import com.spring.beefit.repository.RatingImageRepository;
import com.spring.beefit.repository.RatingRepository;
import com.spring.beefit.viewmodel.request.DanhGiaRequest;
import com.spring.beefit.viewmodel.request.RatingImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingImageRepository ratingImageRepository;

    public Rating addRating(DanhGiaRequest request){
        Rating rating = new Rating();
        rating.setScore(request.getScore());
        rating.setNote(request.getNote());
         rating.setCreateDate(new Date());
         rating.setCustomer(Customer.builder().id(request.getIdCustomer()).build());
         rating.setProduct(Product.builder().id(request.getIdProduct()).build());
         rating.setStatus(0);
         return ratingRepository.save(rating);
    }

    public RatingImage addRatingImage(RatingImageRequest request){
        RatingImage ratingImage = new RatingImage();
        ratingImage.setUrl(request.getUrl());
        ratingImage.setRating(Rating.builder().id(request.getIdRating()).build());
        return ratingImageRepository.save(ratingImage);
    }

}
