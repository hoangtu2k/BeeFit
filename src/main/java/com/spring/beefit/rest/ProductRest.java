package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailService;
import com.spring.beefit.viewmodel.request.ProductDetailReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sanpham")
public class ProductRest {

    @Autowired
    private ProductDetailService service;

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody ProductDetailReq product, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
            return ResponseEntity.ok(service.addProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody ProductDetailReq product){
        return ResponseEntity.ok(service.updateProduct(id,product));
    }
}
