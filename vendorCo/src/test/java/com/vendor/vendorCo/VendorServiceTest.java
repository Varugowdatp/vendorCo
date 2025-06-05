package com.vendor.vendorCo;

import com.vendor.vendorCo.model.Vendor;
import com.vendor.vendorCo.repository.VendorRepository;
import com.vendor.vendorCo.service.VendorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VendorServiceTest {

    private final VendorRepository vendorRepository = mock(VendorRepository.class);
    private final VendorServiceImpl vendorService = new VendorServiceImpl(vendorRepository);

    @Test
    void testGetVendorById() {
        Vendor vendor = Vendor.builder()
                .id(1L)
                .name("XYZ Ltd")
                .contactPerson("Alice")
                .contactEmail("alice@xyz.com")
                .contactPhone("9999999999")
                .services("Software")
                .paymentTerms("60 Days")
                .build();

        when(vendorRepository.findById(1L)).thenReturn(Optional.of(vendor));
        Vendor result = vendorService.getVendorById(1L);

        assertNotNull(result);
        assertEquals("XYZ Ltd", result.getName());
    }

    @Test
    void testGetAllVendors() {
        when(vendorRepository.findAll()).thenReturn(List.of(new Vendor(), new Vendor()));
        assertEquals(2, vendorService.getAllVendors().size());
    }
}
