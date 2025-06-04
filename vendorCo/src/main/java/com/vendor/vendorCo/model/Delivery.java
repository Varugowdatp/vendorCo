package com.vendor.vendorCo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "Delivery")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Vendor ID is required")
    private String vendorId;

    @NotBlank(message = "Order ID is required")
    private String orderId;

    @NotBlank(message = "Scheduled date is required")
    private String scheduledDate;

    private boolean isDelivered;
}
