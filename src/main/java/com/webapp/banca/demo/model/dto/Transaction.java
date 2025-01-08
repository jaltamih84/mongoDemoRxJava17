package com.webapp.banca.demo.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Transaction {
    private String clientId;
    private String type;
    private BigDecimal amount;
    private String date;
    private String description;
}
