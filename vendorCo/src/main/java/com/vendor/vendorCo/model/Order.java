package com.vendor.vendorCo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Vendor ID is required")
    private String vendorId;

    @NotBlank(message = "Product name is required")
    private String product;

    @NotBlank(message = "Order status is required")
    private String status; // Pending, Confirmed, Shipped, Delivered

    @NotBlank(message = "Order date is required")
    private String orderDate;
}
