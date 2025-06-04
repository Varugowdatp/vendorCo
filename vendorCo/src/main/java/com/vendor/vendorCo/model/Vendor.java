package com.vendor.vendorCo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "Vendors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Vendor name is required")
    private String name;

    @NotBlank(message = "Contact person is required")
    private String contactPerson;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Contact email is required")
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String contactPhone;

    @NotBlank(message = "Services field is required")
    private String services;

    @NotBlank(message = "Payment terms are required")
    private String paymentTerms;
}
