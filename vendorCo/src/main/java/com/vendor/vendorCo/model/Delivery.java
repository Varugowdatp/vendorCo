package com.vendor.vendorCo.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "deliveries")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery {
    @Id
    private String id;
    private String vendorId;
    private String orderId;
    private String scheduledDate;
    private boolean isDelivered;
}
