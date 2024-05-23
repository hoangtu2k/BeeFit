package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailMaterialService;
import com.spring.beefit.viewmodel.request.ProductReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productdetail_material")
public class ProductDetail_MaterialRest {

    @Autowired
    private ProductDetailMaterialService service;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ProductReq request){
        return ResponseEntity.ok(service.add(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok("ok");
    }


}
