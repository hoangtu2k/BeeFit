package com.spring.beefit.service;

import com.spring.beefit.entity.Color;
import com.spring.beefit.entity.ProductDetail;
import com.spring.beefit.entity.ProductdetailColorSize;
import com.spring.beefit.entity.Size;
import com.spring.beefit.repository.ColorRepository;
import com.spring.beefit.repository.ProductDetailColorSizeRepository;
import com.spring.beefit.repository.SizeRepository;
import com.spring.beefit.viewmodel.request.ProductDetailReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailColorSizeService {

    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ProductDetailColorSizeRepository productDetailColorSizeRepository;

    public List<Size> getAllSizes() {
        return sizeRepository.getAll();
    }
    public List<Color> getAllColors() {
        return colorRepository.getAll();
    }

    public ProductdetailColorSize add(ProductDetailReq request){
        ProductdetailColorSize productdetailColorSize = new ProductdetailColorSize();
        productdetailColorSize.setProductDetail(ProductDetail.builder().id(request.getIdProductDetail()).build());
        productdetailColorSize.setColor(Color.builder().id(request.getIdColor()).build());
        productdetailColorSize.setSize(Size.builder().id(request.getIdSize()).build());
        productdetailColorSize.setQuantity(request.getQuantity());
        return productDetailColorSizeRepository.save(productdetailColorSize);
    }

    public void delete(Integer idProductDetail){
        List<ProductdetailColorSize> list = productDetailColorSizeRepository.getAllById(idProductDetail);
        for(ProductdetailColorSize p : list){
            productDetailColorSizeRepository.delete(p);
        }
    }

}
