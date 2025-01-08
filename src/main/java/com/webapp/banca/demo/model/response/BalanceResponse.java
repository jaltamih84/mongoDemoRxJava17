package com.webapp.banca.demo.model.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class BalanceResponse {
    private String clientId;
    private BigDecimal accountBalance;
}
