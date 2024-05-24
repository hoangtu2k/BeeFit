package com.spring.beefit.service;

import com.spring.beefit.entity.Color;
import com.spring.beefit.entity.Product;
import com.spring.beefit.entity.ProductdetailColorSize;
import com.spring.beefit.entity.Size;
import com.spring.beefit.repository.ColorRepository;
import com.spring.beefit.repository.ProductDetailColorSizeRepository;
import com.spring.beefit.repository.SizeRepository;
import com.spring.beefit.viewmodel.request.ProductReq;
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

    // size repo
    public List<Size> getAllSizes() {
        return sizeRepository.getAll();
    }

    // color repo
    public List<Color> getAllColors() {
        return colorRepository.getAll();
    }

    public List<Integer> getColorByProduct(Integer Id){
        return colorRepository.getColorByProduct(Id);
    }

    public ProductdetailColorSize add(ProductReq request){
        ProductdetailColorSize productdetailColorSize = new ProductdetailColorSize();
        productdetailColorSize.setProduct(Product.builder().id(request.getIdProduct()).build());
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
