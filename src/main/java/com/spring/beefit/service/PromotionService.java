package com.spring.beefit.service;

import com.spring.beefit.entity.ProductDetail;
import com.spring.beefit.entity.Promotion;
import com.spring.beefit.repository.ProductDetailRepository;
import com.spring.beefit.repository.PromotionRepository;
import com.spring.beefit.viewmodel.request.PromotionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    // CRUD Promotion
    public List<Promotion> getAllPromotions() {
        return promotionRepository.getAll();
    }

    public Promotion createPromotion(PromotionRequest request) {
        Promotion promotion = new Promotion();
        promotion.setCode(request.getCode());
        promotion.setName(request.getName());
        promotion.setDiscountType(request.getDiscountType());
        promotion.setIsDiscount(request.getIsDiscount());
        promotion.setDiscount(request.getDiscount());
        promotion.setCash(request.getCash());
        promotion.setStartDate(request.getStartDate());
        promotion.setEndDate(request.getEndDate());
        promotion.setCreateBy(request.getCreateBy());
        promotion.setCreateDate(new Date());
        promotion.setStatus(0);
        return promotionRepository.save(promotion);
    }

    public void updatePromotionForAllProducts(Integer promotionId) {
        Promotion promotion = promotionRepository.getById(promotionId);
        List<ProductDetail> allProductDetails = productDetailRepository.getAll();
        for (ProductDetail productDetail : allProductDetails) {
            productDetail.setPromotion(promotion);
            productDetailRepository.save(productDetail);
        }
    }

}
