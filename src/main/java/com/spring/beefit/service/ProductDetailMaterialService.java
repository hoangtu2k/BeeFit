package com.spring.beefit.service;

import com.spring.beefit.entity.Material;
import com.spring.beefit.entity.Product;
import com.spring.beefit.entity.ProductdetailMaterial;
import com.spring.beefit.repository.MaterialRepository;
import com.spring.beefit.repository.ProductDetailMaterialRepository;
import com.spring.beefit.viewmodel.request.ProductReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailMaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ProductDetailMaterialRepository productDetailMaterialRepository;

    public List<Material> getAllMaterials() {
        return materialRepository.getAll();
    }

    public ProductdetailMaterial add(ProductReq request){
        ProductdetailMaterial productdetailMaterial = new ProductdetailMaterial();
        productdetailMaterial.setProduct(Product.builder().id(request.getIdProduct()).build());
        productdetailMaterial.setMaterial(Material.builder().id(request.getIdMaterial()).build());
        return productDetailMaterialRepository.save(productdetailMaterial);
    }

    public void delete(Integer idProductDetail){
        List<ProductdetailMaterial> list = productDetailMaterialRepository.getAllById(idProductDetail);
        for(ProductdetailMaterial p : list){
            productDetailMaterialRepository.delete(p);
        }
    }


}
