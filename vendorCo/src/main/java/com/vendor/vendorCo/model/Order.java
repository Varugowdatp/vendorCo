package com.vendor.vendorCo.model;

import jakarta.persistence.*;
import lombok.*;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "orders")
@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String vendorId;
    private String product;
    private String status; // Pending, Confirmed, Shipped, Delivered
    private String orderDate;
}
