package com.spring.beefit.service;

import com.spring.beefit.entity.*;
import com.spring.beefit.repository.MaterialRepository;
import com.spring.beefit.repository.ProductDetailMaterialRepository;
import com.spring.beefit.viewmodel.request.AttributesRequest;
import com.spring.beefit.viewmodel.request.ProductReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Material addMaterial(AttributesRequest request){
        Material material = new Material();
        material.setName(request.getName());
        material.setCreateDate(new Date());
        material.setStatus(0);
        return materialRepository.save(material);
    }
    public Material updateMaterial(Integer Id, AttributesRequest request){
        Material material = materialRepository.getById(Id);
        material.setName(request.getName());
        material.setUpdateDate(new Date());
        return materialRepository.save(material);
    }

    public List<Integer> getMaterialByProduct(Integer Id){
        return materialRepository.getMaterialByProduct(Id);
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
