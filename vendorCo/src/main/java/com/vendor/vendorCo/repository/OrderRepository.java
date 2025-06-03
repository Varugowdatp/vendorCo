package com.vendor.vendorCo.repository;// OrderRepository.java


import com.vendor.vendorCo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
