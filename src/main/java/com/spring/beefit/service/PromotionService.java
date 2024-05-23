package com.spring.beefit.service;

import com.spring.beefit.entity.Product;
import com.spring.beefit.entity.Promotion;
import com.spring.beefit.repository.ProductRepository;
import com.spring.beefit.repository.PromotionRepository;
import com.spring.beefit.viewmodel.request.PromotionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private ProductRepository productRepository;

    // CRUD Promotion
    public List<Promotion> getAllPromotions() {
        return promotionRepository.getAll();
    }

    public List<Promotion> getByEndDateAll() {
        return promotionRepository.getByEndDateAll();
    }

    public Promotion getByCode(String code){
        return promotionRepository.getByCode(code);
    }

    public String genCode() {
        // Tạo đối tượng Random
        long timestamp = Instant.now().getEpochSecond();
        String code = "KM" + timestamp;
        return code;
    }

    public Promotion createPromotion(PromotionReq request) {
        Promotion promotion = new Promotion();
        promotion.setCode(genCode());
        promotion.setName(request.getName());
        promotion.setDiscountType(request.getDiscountType());
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
        List<Product> products = productRepository.getAll();
        for (Product product : products) {
            product.setPromotion(promotion);
            productRepository.save(product);
        }
    }

}
