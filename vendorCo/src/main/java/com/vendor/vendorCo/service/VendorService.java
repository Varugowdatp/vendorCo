package com.vendor.vendorCo.service;

import com.vendor.vendorCo.model.Vendor;
import com.vendor.vendorCo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    /**
     * Add a new vendor to the database.
     */
    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    /**
     * Fetch all vendors from the database.
     */
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    /**
     * Get a vendor by ID.
     */
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id).orElse(null);
    }

    /**
     * Save or update a vendor.
     */
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    /**
     * Delete a vendor by ID.
     */
    public void deleteVendor(Long id) {
        if (!vendorRepository.existsById(id)) {
            throw new IllegalArgumentException("Vendor not found with id: " + id);
        }
        vendorRepository.deleteById(id);
    }
}
