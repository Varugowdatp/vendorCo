package com.vendor.vendorCo.controller;

import com.vendor.vendorCo.model.Delivery;
import com.vendor.vendorCo.repository.DeliveryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeliveryController.class)
public class DeliveryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryRepository deliveryRepository;

    @Test
    void testGetAllDeliveries() throws Exception {
        Delivery delivery = new Delivery(1L, "V123", "O789", "2025-06-03", true);

        when(deliveryRepository.findAll()).thenReturn(List.of(delivery));

        mockMvc.perform(get("/api/deliveries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].vendorId").value("V123"));
    }

    @Test
    void testGetDeliveryById() throws Exception {
        Delivery delivery = new Delivery(2L, "V200", "O900", "2025-06-04", false);

        when(deliveryRepository.findById(2L)).thenReturn(Optional.of(delivery));

        mockMvc.perform(get("/api/deliveries/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").value("O900"));
    }
}
