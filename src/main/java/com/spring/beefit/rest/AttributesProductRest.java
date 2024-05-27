package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailColorSizeService;
import com.spring.beefit.service.ProductDetailMaterialService;
import com.spring.beefit.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AttributesProductRest {

    @Autowired
    private ProductDetailService productDetailServicee;

    @Autowired
    private ProductDetailMaterialService productDetailMaterialService;

    @Autowired
    private ProductDetailColorSizeService productDetailColorSizeService;

    @GetMapping("/brand")
    public ResponseEntity<?> getAllBrands(){
        return ResponseEntity.ok(productDetailServicee.getAllBrands());
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(productDetailServicee.getAllCategories());
    }

    @GetMapping("/design")
    public ResponseEntity<?> getAllDesigns(){
        return ResponseEntity.ok(productDetailServicee.getAllDesigns());
    }

    @GetMapping("/handtype")
    public ResponseEntity<?> getAllHandTypes(){
        return ResponseEntity.ok(productDetailServicee.getAllHandTypes());
    }

    @GetMapping("/necktype")
    public ResponseEntity<?> getAllNeckTypes(){
        return ResponseEntity.ok(productDetailServicee.getAllNeckTypes());
    }

    @GetMapping("/material")
    public ResponseEntity<?> getAllMaterials(){
        return ResponseEntity.ok(productDetailMaterialService.getAllMaterials());
    }

    @GetMapping("/size")
    public ResponseEntity<?> getAllSizes(){
        return ResponseEntity.ok(productDetailColorSizeService.getAllSizes());
    }

    @GetMapping("/color")
    public ResponseEntity<?> getAllColors(){
        return ResponseEntity.ok(productDetailColorSizeService.getAllColors());
    }

    @GetMapping("/color/get/{id}")
    public ResponseEntity<?> getColorById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productDetailColorSizeService.getColorByProduct(id));
    }

}
