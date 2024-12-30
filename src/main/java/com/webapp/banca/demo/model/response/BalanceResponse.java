package com.webapp.banca.demo.model.response;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class BalanceResponse {
    private String clientId;
    private Double accountBalance;
}
