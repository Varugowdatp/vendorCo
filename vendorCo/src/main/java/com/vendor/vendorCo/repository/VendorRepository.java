package com.vendor.vendorCo.repository;

// VendorRepository.java


import com.vendor.vendorCo.model.Vendor;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;



public interface VendorRepository extends JpaRepository<Vendor, Long> {

}