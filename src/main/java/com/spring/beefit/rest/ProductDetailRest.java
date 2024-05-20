package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailExelService;
import com.spring.beefit.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/product")
public class ProductDetailRest {

    @Autowired
    private ProductDetailService service;

    @Autowired
    private ProductDetailExelService productDetailExelService;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getall1")
    public ResponseEntity<?> getAll1(){
        return ResponseEntity.ok(service.getAll1());
    }

    @PostMapping( value = "/importExel", consumes = "multipart/form-data")
    public ResponseEntity<String> importExel(@RequestParam("file") MultipartFile file) throws IOException {
        try{
            productDetailExelService.importExel(file);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
        }
        catch(IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }

    }



}
