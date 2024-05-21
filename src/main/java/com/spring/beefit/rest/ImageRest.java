package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailService;
import com.spring.beefit.viewmodel.request.ProductDetailReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/image")
public class ImageRest {
    @Autowired
    private ProductDetailService service;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDetailReq image){
        return ResponseEntity.ok(service.addImage(image));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.deleteImg(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/1/{id}")
    public ResponseEntity<?> delete1(@PathVariable("id") Integer id){
        service.delete1(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
