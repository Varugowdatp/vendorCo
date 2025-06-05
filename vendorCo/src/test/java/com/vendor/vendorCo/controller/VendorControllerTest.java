package com.vendor.vendorCo.controller;

import com.vendor.vendorCo.controller.VendorController;
import com.vendor.vendorCo.model.Vendor;
import com.vendor.vendorCo.service.VendorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VendorController.class)
public class VendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VendorService vendorService;

    @Test
    void testGetAllVendors() throws Exception {
        Vendor vendor = Vendor.builder()
                .id(1L)
                .name("ABC Supplies")
                .contactPerson("John Doe")
                .contactEmail("abc@example.com")
                .contactPhone("9876543210")
                .services("Electronics")
                .paymentTerms("30 Days")
                .build();

        when(vendorService.getAllVendors()).thenReturn(List.of(vendor));

        mockMvc.perform(get("/api/vendors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("ABC Supplies"));
    }
}
