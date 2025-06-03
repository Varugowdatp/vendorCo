package com.vendor.vendorCo.repository;// OrderRepository.java


import com.vendor.vendorCo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {}
