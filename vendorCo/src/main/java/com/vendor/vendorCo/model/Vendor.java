package com.vendor.vendorCo.model;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
public class Vendor {
    @Id

    private String id;
    private String name;
    private String contactPerson;
    private String contactEmail;
    private String contactPhone;
    private String services;
    private String paymentTerms;
}
