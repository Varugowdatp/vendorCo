package com.vendor.vendorCo.repository;// DeliveryRepository.java


import com.vendor.vendorCo.model.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepository extends MongoRepository<Delivery, String> {}
