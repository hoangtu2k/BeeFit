package com.spring.beefit.service;

import com.spring.beefit.entity.Voucher;
import com.spring.beefit.repository.VoucherRepository;
import com.spring.beefit.viewmodel.request.VoucherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository repository;

    public List<Voucher> getAll(){
        return repository.getAll();
    }

    public List<Voucher> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }

    public Voucher getById(Integer Id){
        Voucher voucher = repository.getById(Id);
        return voucher;
    }

    public Voucher add(VoucherRequest request){
        Voucher voucher = new Voucher();
        voucher.setCode(request.getCode());
        voucher.setName(request.getName());
        voucher.setDiscountType(request.getDiscountType());
        voucher.setDiscount(request.getDiscount());
        voucher.setCash(request.getCash());
        voucher.setStartDate(request.getStartDate());
        voucher.setEndDate(request.getEndDate());
        voucher.setQuantity(request.getQuantity());
        voucher.setCreateBy(request.getCreateBy());
        voucher.setCreateDate(new Date());
        voucher.setStatus(0);
        return repository.save(voucher);
    }

    public Voucher update(Integer id, VoucherRequest request){
        Voucher voucher = repository.getById(id);
        voucher.setCode(request.getCode());
        voucher.setName(request.getName());
        voucher.setDiscountType(request.getDiscountType());
        voucher.setDiscount(request.getDiscount());
        voucher.setCash(request.getCash());
        voucher.setStartDate(request.getStartDate());
        voucher.setEndDate(request.getEndDate());
        voucher.setQuantity(request.getQuantity());
        voucher.setUpdateBy(request.getUpdateBy());
        voucher.setUpdateDate(new Date());
        voucher.setStatus(0);
        return repository.save(voucher);
    }

    public Voucher delete(Integer Id){
        Voucher voucher = repository.getById(Id);
        voucher.setStatus(2);
        return repository.save(voucher);
    }

    public Voucher updateQuantityBill(Integer Id) {
        Voucher voucher = repository.getById(Id);
        if (voucher != null) {
            voucher.setQuantity(voucher.getQuantity() - 1);
            return repository.save(voucher);
        } else if (voucher.getQuantity() <= 0){
            voucher.setQuantity(0);
            return repository.save(voucher);
        } else {
            return voucher; // Trả về voucher = null
        }
    }

}
