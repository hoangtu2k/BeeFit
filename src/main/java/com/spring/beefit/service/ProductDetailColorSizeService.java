package com.spring.beefit.service;

import com.spring.beefit.entity.Color;
import com.spring.beefit.entity.Size;
import com.spring.beefit.repository.ColorRepository;
import com.spring.beefit.repository.ProductDetailColorSizeRepository;
import com.spring.beefit.repository.SizeRepository;
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

}
