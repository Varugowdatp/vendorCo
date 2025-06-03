package com.vendor.vendorCo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    private String id;
    private String vendorId;
    private String product;
    private String status; // Pending, Confirmed, Shipped, Delivered
    private String orderDate;
}
