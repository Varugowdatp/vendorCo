package com.vendor.vendorCo.repository;// DeliveryRepository.java


import com.vendor.vendorCo.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {}
