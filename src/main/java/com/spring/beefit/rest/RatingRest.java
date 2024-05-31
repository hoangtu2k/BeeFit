package com.spring.beefit.rest;

import com.spring.beefit.service.RatingService;
import com.spring.beefit.viewmodel.request.DanhGiaRequest;
import com.spring.beefit.viewmodel.request.RatingImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RatingRest {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rating")
    public ResponseEntity<?> add(@RequestBody DanhGiaRequest request){
        return ResponseEntity.ok(ratingService.addRating(request));
    }

    @PostMapping("/ratingimage")
    public ResponseEntity<?> add(@RequestBody RatingImageRequest request){
        return ResponseEntity.ok(ratingService.addRatingImage(request));
    }

}
