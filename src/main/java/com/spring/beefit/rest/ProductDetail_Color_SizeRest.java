package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailColorSizeService;
import com.spring.beefit.viewmodel.request.ProductDetailReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productdetail_color_size")
public class ProductDetail_Color_SizeRest {

    @Autowired
    private ProductDetailColorSizeService service;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ProductDetailReq request){
        return ResponseEntity.ok(service.add(request));
    }

}
