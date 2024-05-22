package com.spring.beefit.rest;

import com.spring.beefit.service.PromotionService;
import com.spring.beefit.viewmodel.request.PromotionRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotion")
public class PromotionRest {

    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public ResponseEntity<?> getAllPromotions(){
        return ResponseEntity.ok(promotionService.getAllPromotions());
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody PromotionRequest validatePromotion, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(promotionService.createPromotion(validatePromotion));
    }

    


}
