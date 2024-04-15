package com.microservice.jpa.buildinginventory.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
@Id
private int productId;
private String productName;
private String productDescription;
private BigDecimal productPrice;
}
