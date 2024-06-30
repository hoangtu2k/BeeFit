package com.spring.beefit.service;


import com.spring.beefit.entity.Address;
import com.spring.beefit.entity.Bill;
import com.spring.beefit.entity.Customer;
import com.spring.beefit.entity.Employee;
import com.spring.beefit.repository.BillRepository;
import com.spring.beefit.viewmodel.request.*;
import com.spring.beefit.viewmodel.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository repository;

    private String getNextMa() {
        String biggestMa = repository.getBiggestMa();
        if (biggestMa == null || biggestMa.isEmpty()) {
            return "HD01";
        } else {
            int currentMa = Integer.parseInt(biggestMa.substring(2));
            String newMa = "HD" + String.format("%02d", ++currentMa);
            return newMa;
        }
    }

    public Bill add(BillRequest request){
        Bill bill = new Bill();
        bill.setCode(getNextMa());
        bill.setPurchaseDate(new Date());
        bill.setNote(request.getNote());
        bill.setShipPrice(request.getShipPrice());
        bill.setTotalPrice(request.getTotalPrice());
        bill.setTotalPriceLast(request.getTotalPriceLast());
        bill.setPayStatus(request.getPayStatus());
        bill.setPayType(request.getPayType());
        bill.setIdCoupon(request.getIdCoupon());
        bill.setAddress(Address.builder().Id(request.getIdAddress()).build());
        if(request.getIdCustomer() != -1){
            bill.setCustomer(Customer.builder().id(request.getIdCustomer()).build());
        }
        bill.setStatus(request.getStatus());
        bill.setTypeStatus(request.getTypeStatus());
        return repository.save(bill);

    }
    public Bill update(String code, BillTaiQuayUpdateRequest request){
        Bill bill = repository.getByCode(code);
        bill.setNote(request.getNote());
        bill.setShipPrice(request.getShipPrice());
        bill.setTotalPrice(request.getTotalPrice());
        bill.setTotalPriceLast(request.getTotalPriceLast());
        bill.setPayStatus(request.getPayStatus());
        bill.setPayType(request.getPayType());
        bill.setIdCoupon(request.getIdCoupon());
       if(request.getIdAddress() != 0){
           bill.setAddress(Address.builder().Id(request.getIdAddress()).build());
       }
        bill.setStatus(request.getStatus());
        bill.setPaymentDate(request.getPaymentDate());
        bill.setDelyveryDate(request.getDelyveryDate());
        if(request.getIdCustomer() != 0){
            bill.setCustomer(Customer.builder().id(request.getIdCustomer()).build());
        }
        bill.setTypeStatus(request.getTypeStatus());
        return repository.save(bill);
    }
    public Bill updateStatus(String code, UpdateThanhToanTaiQuay request){
        Bill bill = repository.getByCode(code);
        bill.setStatus(request.getStatus());
        bill.setDelyveryDate(request.getDeliveryDate());
        bill.setPayStatus(request.getPayStatus());
        bill.setPaymentDate(request.getPaymentDate());
        return repository.save(bill);
    }
    public List<BillResponse> getBillFilter(Integer status, Integer payStatus, Integer payType, Integer typeStatus, String tungay, String denngay ){
        return repository.getBillFilter(status,payStatus,payType,typeStatus,tungay,denngay);
    }
    public Bill updateStatus1(String code, UpdateThanhToanTaiQuay request){
        Bill bill = repository.getByCode(code);
        bill.setDelyveryDate(new Date());
        bill.setPayStatus(request.getPayStatus());
        bill.setPaymentDate(new Date());
        return repository.save(bill);

    }
    public Bill updateStatusPay(String code){
    Bill bill = repository.getByCode(code);
    bill.setPayStatus(1);
    bill.setStatus(0);
    bill.setPaymentDate(new Date());
    return repository.save(bill);
    }
    public Bill updateStatus(UpdateBillStatus updateBillStatus){
        Bill bill = repository.getByCode(updateBillStatus.getCode());
        bill.setStatus(updateBillStatus.getStatus());
        return repository.save(bill);
    }
    public Bill updateDiaChi(String Code , Integer IdDiachi){
        Bill bill = repository.getByCode(Code);
        bill.setAddress(Address.builder().Id(IdDiachi).build());
        return repository.save(bill);
    }
    public Bill updateTongTien(String Code , BigDecimal money){
        Bill bill = repository.getByCode(Code);
        bill.setTotalPrice(money);
        return repository.save(bill);
    }
    public Bill updatePhiShip(UpdateBillShipPrice updateBillShipPrice){
        Bill bill = repository.getByCode(updateBillShipPrice.getCode());
        bill.setShipPrice(updateBillShipPrice.getMoney());
        return repository.save(bill);
    }
    public void huyBill(String code){
        Bill bill = repository.getByCode(code);
        bill.setStatus(4);
        repository.save(bill);
    }
    public void deleteBill(String code){
        Bill bill = repository.getByCode(code);
        repository.delete(bill);
    }
    public List<BillResponse> getBillByCustomer(Integer status , Integer idCustomer){
        return repository.getBillByCustomer(status,idCustomer);
    }
    public List<BillAllResponse> getAllBill(){
        return repository.getAllBill();
    }
    public BillResponse getByCode(String code){
        return repository.getBillBycode(code);
    }
    public List<BillResponse> getAllByStatus(Integer status){
        return repository.getBillByStatus(status);
    }
    public Bill addBillTaiQuay(BillTaiQuayRequest request){
        Bill bill = new Bill();
        bill.setCode(getNextMa());
        bill.setPurchaseDate(new Date());
        bill.setTypeStatus(request.getTypeStatus());
        bill.setStatus(request.getStatus());
        bill.setEmployee(Employee.builder().id(request.getIdEmployee()).build());
        return repository.save(bill);
    }
    public List<BillResponse> getAll(){
        return repository.getAll();
    }

    public TKNgay getTKNgay(){
        return repository.getThongKeNgay();
    }
    public TKThang getTKThang(){
        return repository.getThongKeThang();
    }
    public TKSLThang getTKSLThang(){
        return repository.getThongKeSoLuongThang();
    }


}
