package com.spring.beefit.service;

import com.spring.beefit.entity.Bill;
import com.spring.beefit.entity.BillDetail;
import com.spring.beefit.entity.Product;
import com.spring.beefit.repository.BillDetailRepository;
import com.spring.beefit.viewmodel.request.BillDetailRequest;
import com.spring.beefit.viewmodel.response.BillDaBanResponse;
import com.spring.beefit.viewmodel.response.TKSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailService {

    @Autowired
    private BillDetailRepository repository;

    public BillDetail addBillDetail(BillDetailRequest request){
        BillDetail billDetail = new BillDetail();
        billDetail.setBill(Bill.builder().id(request.getIdBill()).build());
        billDetail.setProduct(Product.builder().id(request.getIdProduct()).build());
        billDetail.setIdColor(request.getIdColor());
        billDetail.setIdSize(request.getIdSize());
        billDetail.setQuantity(request.getQuantity());
        billDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(billDetail);
    }
    public BillDetail updateBillDetail(Integer id,BillDetailRequest request){
        BillDetail billDetail = repository.getById(id);
        billDetail.setQuantity(request.getQuantity());
        billDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(billDetail);
    }
    public List<BillDetail> getAllbyBill(String code){
        return repository.getAllByBill(code);
    }

    public void deleteBillDetail(Integer id){
        BillDetail billDetail = repository.getById(id);
        repository.delete(billDetail);
    }
    public void deleteBillDetailByCode(String code){
        List<BillDetail> list = repository.getAllByBill(code);
        for (BillDetail billDetail: list
             ) {
            repository.delete(billDetail);

        }
    }
    public BillDetail getById(Integer id){
        BillDetail billDetail = repository.getById(id);
        return billDetail;
    }

    public List<BillDaBanResponse> getAllByIdProduct(Integer id){
        return repository.getAllByIdProduct(id);
    }

    public List<TKSanPham> getTKSanPham(){
        return repository.getTKSanPham();
    }

}
