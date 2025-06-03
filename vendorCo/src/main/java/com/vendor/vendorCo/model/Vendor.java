package com.vendor.vendorCo.model;



import jakarta.persistence.*;
import lombok.*;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "vendors")
@Entity
@Table(name = "Vendors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactPerson;
    private String contactEmail;
    private String contactPhone;
    private String services;
    private String paymentTerms;
}
