package com.example.orderbackend.service;

import com.example.orderbackend.entity.OrderItem;
import com.example.orderbackend.entity.Product;
import com.example.orderbackend.exception.OutOfAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    public boolean checkOutOfAmount(List<OrderItem> orderItems) {
        orderItems.forEach(item -> {
            Integer productId = item.getOrderProduct().getProductId();
            Product product = restTemplate.getForObject("http://STORE-PRODUCT/api/products/"+item.getId(), Product.class);
            if (product != null || product.isOutOfAmount(item.getAmount())) {
                throw new OutOfAmountException();
            }
        });
        throw new NotImplementedException();
    }
}
