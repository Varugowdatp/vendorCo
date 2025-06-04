package com.vendor.vendorCo.controller;

import com.vendor.vendorCo.model.Order;
import com.vendor.vendorCo.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderRepo.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @Valid @RequestBody Order updatedOrder) {
        Order existingOrder = orderRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found with id: " + id));
        updatedOrder.setId(existingOrder.getId());
        return orderRepo.save(updatedOrder);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        if (!orderRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found with id: " + id);
        }
        orderRepo.deleteById(id);
    }
}
