package com.vendor.vendorCo.controller;

import com.vendor.vendorCo.model.Delivery;
import com.vendor.vendorCo.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryRepo;

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryRepo.findAll();
    }

    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable String id) {
        return deliveryRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Delivery updateDelivery(@PathVariable String id, @RequestBody Delivery updatedDelivery) {
        updatedDelivery.setId(id);
        return deliveryRepo.save(updatedDelivery);
    }

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable String id) {
        deliveryRepo.deleteById(id);
    }
}
