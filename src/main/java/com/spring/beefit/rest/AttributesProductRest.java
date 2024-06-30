package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailColorSizeService;
import com.spring.beefit.service.ProductDetailMaterialService;
import com.spring.beefit.service.ProductDetailService;
import com.spring.beefit.viewmodel.request.AttributesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/brand")
    public ResponseEntity<?> addBrand(@Valid @RequestBody AttributesRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.addBrand(request));
    }
    @PutMapping("/brand/update/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable("id") Integer Id,@Valid @RequestBody AttributesRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.updateBrand(Id,request));
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(productDetailServicee.getAllCategories());
    }
    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@Valid @RequestBody AttributesRequest category, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.addCategory(category));
    }
    @PutMapping("/category/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Integer Id,@Valid @RequestBody AttributesRequest category, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.updateCategory(Id,category));
    }

    @GetMapping("/design")
    public ResponseEntity<?> getAllDesigns(){
        return ResponseEntity.ok(productDetailServicee.getAllDesigns());
    }
    @PostMapping("/design")
    public ResponseEntity<?> add(@Valid @RequestBody AttributesRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.addDesign(request));
    }
    @PutMapping("/design/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer Id,@Valid @RequestBody AttributesRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.updateDesign(Id,request));
    }

    @GetMapping("/handtype")
    public ResponseEntity<?> getAllHandTypes(){
        return ResponseEntity.ok(productDetailServicee.getAllHandTypes());
    }
    @PostMapping("/handtype")
    public ResponseEntity<?> addHandType(@Valid @RequestBody AttributesRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.addHandType(request));
    }
    @PutMapping("/handtype/update/{id}")
    public ResponseEntity<?> updateHandType(@PathVariable("id") Integer Id,@Valid @RequestBody AttributesRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.updateHandType(Id,request));
    }

    @GetMapping("/necktype")
    public ResponseEntity<?> getAllNeckTypes(){
        return ResponseEntity.ok(productDetailServicee.getAllNeckTypes());
    }
    @PostMapping("/necktype")
    public ResponseEntity<?> addNeckType(@Valid @RequestBody AttributesRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.addNeckType(request));
    }
    @PutMapping("/necktype/update/{id}")
    public ResponseEntity<?> updateNeckType(@PathVariable("id") Integer Id,@Valid @RequestBody AttributesRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailServicee.updateNeckType(Id,request));
    }


    @GetMapping("/material")
    public ResponseEntity<?> getAllMaterials(){
        return ResponseEntity.ok(productDetailMaterialService.getAllMaterials());
    }
    @PostMapping("/material")
    public ResponseEntity<?> addMaterial(@Valid @RequestBody AttributesRequest material, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailMaterialService.addMaterial(material));
    }
    @PutMapping("/material/update/{id}")
    public ResponseEntity<?> updateMaterial(@PathVariable("id") Integer Id,@Valid @RequestBody AttributesRequest material, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailMaterialService.updateMaterial(Id,material));
    }
    @GetMapping("/material/get/{id}")
    public ResponseEntity<?> getMaterialById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productDetailMaterialService.getMaterialByProduct(id));
    }

    @GetMapping("/size")
    public ResponseEntity<?> getAllSizes(){
        return ResponseEntity.ok(productDetailColorSizeService.getAllSizes());
    }
    @PostMapping("/size")
    public ResponseEntity<?> addSize(@Valid @RequestBody AttributesRequest size, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailColorSizeService.addSize(size));
    }
    @PutMapping("/size/update/{id}")
    public ResponseEntity<?> updateSize(@PathVariable("id") Integer Id,@Valid @RequestBody AttributesRequest size, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailColorSizeService.updateSize(Id,size));
    }

    @GetMapping("/color")
    public ResponseEntity<?> getAllColors(){
        return ResponseEntity.ok(productDetailColorSizeService.getAllColors());
    }
    @PostMapping("/color")
    public ResponseEntity<?> addColor(@Valid @RequestBody AttributesRequest color, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailColorSizeService.addColor(color));
    }
    @PutMapping("/color/update/{id}")
    public ResponseEntity<?> updateColor(@PathVariable("id") Integer Id,@Valid @RequestBody AttributesRequest color, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(productDetailColorSizeService.updateColor(Id,color));
    }
    @GetMapping("/color/get/{id}")
    public ResponseEntity<?> getColorById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productDetailColorSizeService.getColorByProduct(id));
    }

}
