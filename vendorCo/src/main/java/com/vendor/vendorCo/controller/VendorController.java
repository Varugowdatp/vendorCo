package com.vendor.vendorCo.controller;

import com.vendor.vendorCo.model.Vendor;
import com.vendor.vendorCo.service.VendorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor createVendor(@Valid @RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }

    @GetMapping
    public List<Vendor> getAll() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        Vendor vendor = vendorService.getVendorById(id);
        if (vendor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor not found with id: " + id);
        }
        return vendor;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVendor(@PathVariable Long id) {
        Vendor vendor = vendorService.getVendorById(id);
        if (vendor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor not found with id: " + id);
        }
        vendorService.deleteVendor(id);
    }
}
