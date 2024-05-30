package com.spring.beefit.service;

import com.spring.beefit.entity.Cart;
import com.spring.beefit.entity.CartDetail;
import com.spring.beefit.entity.Customer;
import com.spring.beefit.entity.Product;
import com.spring.beefit.repository.CartDetailRepository;
import com.spring.beefit.repository.CartRepository;
import com.spring.beefit.viewmodel.request.CartDetailRequest;
import com.spring.beefit.viewmodel.request.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService {

    @Autowired
    private CartDetailRepository repository;

    @Autowired
    private CartRepository cartRepository;

    public List<CartDetail> getCartByCustomer(Integer Id){
        return repository.getCartByCustomer(Id);
    }
    public void deleteAllCart(Integer Id){
        List<CartDetail> cartDetails = repository.getCartByCustomer(Id);
        for (CartDetail cartDetail: cartDetails) {
            repository.delete(cartDetail);
        }
    }
    public CartDetail addToCart(CartDetailRequest request){
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCart(Cart.builder().id(request.getIdCart()).build());
        cartDetail.setProduct(Product.builder().id(request.getIdProduct()).build());
        cartDetail.setIdColor(request.getIdColor());
        cartDetail.setIdSize(request.getIdSize());
        cartDetail.setQuantity(request.getQuantity());
        cartDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(cartDetail);
    }
    public void deleteToCart(Integer Id){
        CartDetail cartDetail = repository.getById(Id);
        repository.delete(cartDetail);
    }
    public CartDetail updateToCart(CartDetailRequest request , Integer id){
        CartDetail cartDetail = repository.getById(id);
        cartDetail.setCart(Cart.builder().id(request.getIdCart()).build());
        cartDetail.setProduct(Product.builder().id(request.getIdProduct()).build());
        cartDetail.setIdColor(request.getIdColor());
        cartDetail.setIdSize(request.getIdSize());
        cartDetail.setQuantity(request.getQuantity());
        cartDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(cartDetail);
    }
    public Integer getQuantityByCartDetail(Integer id){
        return repository.getQuantityByCartDetail(id);
    }

    public Cart getByIdCart(Integer id){
        return cartRepository.getByIdCart(id);
    }

    public Cart getByIdCustomer(Integer id){
        return cartRepository.getByIdCustomer(id);
    }

    public  Cart addCart(CartRequest request){
        Cart cart = new Cart();
        cart.setCustomer(Customer.builder().id(request.getIdCustomer()).build());
        return cartRepository.save(cart);
    }


}
