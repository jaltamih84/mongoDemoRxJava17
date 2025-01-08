package com.webapp.banca.demo.model.response;

import com.webapp.banca.demo.model.dto.Transaction;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class TransactionResponse {
    private String type;
    private BigDecimal amountBalance;
    private String date;
    private Transaction[] transactions;
}
