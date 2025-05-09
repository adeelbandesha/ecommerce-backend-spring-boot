package com.ecommerce.ecommerce_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private String customerName;
    private String customerEmail;
    private String shippingAddress;
    private String phone;
    private List<Long> productIds;
}
