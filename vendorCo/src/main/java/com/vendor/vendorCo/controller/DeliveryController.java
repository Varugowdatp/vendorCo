package com.vendor.vendorCo.controller;

import com.vendor.vendorCo.model.Delivery;
import com.vendor.vendorCo.repository.DeliveryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery createDelivery(@Valid @RequestBody Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryRepo.findAll();
    }

    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable Long id) {
        return deliveryRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Delivery updateDelivery(@PathVariable Long id, @Valid @RequestBody Delivery updatedDelivery) {
        Delivery existing = deliveryRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found with id: " + id));
        updatedDelivery.setId(existing.getId());
        return deliveryRepo.save(updatedDelivery);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDelivery(@PathVariable Long id) {
        if (!deliveryRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found with id: " + id);
        }
        deliveryRepo.deleteById(id);
    }
}
