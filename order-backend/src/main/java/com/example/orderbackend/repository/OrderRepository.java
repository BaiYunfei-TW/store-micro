package com.example.orderbackend.repository;

import com.example.orderbackend.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
}
