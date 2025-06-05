package com.vendor.vendorCo.controller;

import com.vendor.vendorCo.controller.OrderController;
import com.vendor.vendorCo.model.Order;
import com.vendor.vendorCo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    void testGetAllOrders() throws Exception {
        Order order = Order.builder()
                .id(1L)
                .vendorId("V100")
                .product("Laptops")
                .status("Confirmed")
                .orderDate("2025-06-01")
                .build();

        when(orderRepository.findAll()).thenReturn(List.of(order));

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].product").value("Laptops"));
    }

    @Test
    void testGetOrderById() throws Exception {
        Order order = Order.builder()
                .id(2L)
                .vendorId("V200")
                .product("Monitors")
                .status("Pending")
                .orderDate("2025-06-02")
                .build();

        when(orderRepository.findById(2L)).thenReturn(Optional.of(order));

        mockMvc.perform(get("/api/orders/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product").value("Monitors"));
    }
}
