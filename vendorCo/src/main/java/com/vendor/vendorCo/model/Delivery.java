package com.vendor.vendorCo.model;

import jakarta.persistence.*;
import lombok.*;

//import org.springframework.data.mongodb.core.mapping.Document;
@Entity
@Table(name = "Delivery")
//@Document(collection = "deliveries")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vendorId;
    private String orderId;
    private String scheduledDate;
    private boolean isDelivered;
}
