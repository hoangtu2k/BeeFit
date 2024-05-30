package com.spring.beefit.service;

import com.spring.beefit.entity.Customer;
import com.spring.beefit.repository.CustomerRepository;
import com.spring.beefit.viewmodel.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    public List<Customer> getAll1() {
        return customerRepository.getAll1();
    }

    public Customer getByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public Customer getById(Integer Id){
        Customer customer = customerRepository.getById(Id);
        return customer;
    }

    public String genCode(){
        // Tạo đối tượng Random
        long timestamp = Instant.now().getEpochSecond();
        String code = "KH" + timestamp;
        return code;
    }
    // đăng ký
    public Customer register(RegisterForm form){
        Customer customer = new Customer();
        customer.setCode(genCode());
        customer.setEmail(form.getEmail());
        customer.setFullname(form.getFullname());
        customer.setUsername(form.getUsername());
        customer.setPassword(form.getPassword());
        customer.setCreateDate(new Date());
        customer.setStatus(0);
        return customerRepository.save(customer);
    }

    // Tim khach hang
    public List<Customer> getAllbyFullName(String fullname){
        return customerRepository.searchByFullName('%'+fullname+'%');
    }
    // add khach hang
    public Customer add(CustomerReques reques){
        Customer customer = new Customer();
        customer.setCode(reques.getCode());
        customer.setFullname(reques.getFullname());
        customer.setUsername(reques.getUsername());
        customer.setPassword(reques.getPassword());
        customer.setImage(reques.getImage());
        customer.setGender(reques.getGender());
        customer.setPhone(reques.getPhone());
        customer.setEmail(reques.getEmail());
        customer.setStatus(0);
        return customerRepository.save(customer);
    }
    // update khach hang
    public  Customer update(Integer id , CustomerReques reques){
        Customer customer = customerRepository.getById(id);
        customer.setCode(reques.getCode());
        customer.setFullname(reques.getFullname());
        customer.setUsername(reques.getUsername());
        customer.setPassword(reques.getPassword());
        customer.setImage(reques.getImage());
        customer.setGender(reques.getGender());
        customer.setPhone(reques.getPhone());
        customer.setEmail(reques.getEmail());
        customer.setStatus(0);
        return customerRepository.save(customer);
    }
    // xoa khach hang
    public  Customer delete(Integer id ){
        Customer customer = customerRepository.getById(id);
        customer.setStatus(1);
        return  customerRepository.save(customer);
    }
    public  Customer delete1(Integer id ){
        Customer customer = customerRepository.getById(id);
        customer.setStatus(0);
        return  customerRepository.save(customer);
    }

    // đổi mật khẩu
    public Customer change(Integer idCustomer, ChangeForm form){
        Customer customer = customerRepository.getById(idCustomer);
        customer.setPassword(form.getRePasswordMoi());
        customer.setUpdateDate(new Date());
        return customerRepository.save(customer);
    }

    //cập nhật profile
    public Customer updateprofile(Integer idCustomer, CapNhatProfile form){
        Customer customer = customerRepository.getById(idCustomer);
        customer.setFullname(form.getFullname());
        customer.setEmail(form.getEmail());
        customer.setPhone(form.getPhone());
        customer.setGender(form.getGender());
        customer.setImage(form.getImage());
        customer.setUpdateDate(new Date());
        return customerRepository.save(customer);
    }

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
    // quên mật khẩu
    public Customer forget(ForgetForm form){
        Customer customer = customerRepository.getByUsername(form.getUsername());
        customer.setPassword(generateRandomString(8));
        customer.setUpdateDate(new Date());
        return customerRepository.save(customer);
    }
    //check đk đánh giá
    public Customer checkdk(Integer IdCustomer ,Integer IdProduct){
        return customerRepository.checkDanhGia(IdCustomer,IdProduct);
    }

}
