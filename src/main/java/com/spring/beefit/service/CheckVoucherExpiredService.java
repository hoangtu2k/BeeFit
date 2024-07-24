package com.spring.beefit.service;

import com.spring.beefit.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CheckVoucherExpiredService {

    @Autowired
    private VoucherRepository repository;
    @Scheduled(cron = "0 * * * * *") // Chạy sau mỗi phút
    public void updateExpiredDiscounts() {
        System.out.println("Đã check voucher hết hạn");
        repository.updateExpensive();
    }

}