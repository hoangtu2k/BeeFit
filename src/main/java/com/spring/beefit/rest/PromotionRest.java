package com.spring.beefit.rest;

import com.spring.beefit.service.PromotionService;
import com.spring.beefit.viewmodel.request.PromotionReq;
import com.spring.beefit.viewmodel.request.ValidatePromotion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/enddatetrue")
    public ResponseEntity<?> getByEndDateAll(){
        return ResponseEntity.ok(promotionService.getByEndDateAll());
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@Valid @RequestBody ValidatePromotion validateForm, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            list.forEach(error -> System.out.println(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(list);
        }
        if (promotionService.getByCode(validateForm.getCode()) != null) {
            System.out.println("Mã khuyến mãi đã tồn tại: " + validateForm.getCode());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        System.out.println("Validation thành công cho mã khuyến mãi: " + validateForm.getCode());
        return ResponseEntity.ok(validateForm);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody PromotionReq validatePromotion, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(promotionService.createPromotion(validatePromotion));
    }

    


}
