package com.spring.beefit.service;

import com.spring.beefit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CheckDiscountExpiredService {

    @Autowired
    private ProductRepository repository;
    @Scheduled(cron = "0 0 0 * * *")
    public void updateExpiredDiscounts() {
        System.out.println("Đã check giảm giá hết hạn");
        repository.updateDiscount();
    }

}
