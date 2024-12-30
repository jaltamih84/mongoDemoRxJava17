package com.webapp.banca.demo.model.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Product {
    private String productId;
    private String code;
    private String description;
    private int type;
    private int active;
}
