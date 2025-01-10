package com.webapp.banca.demo.model.request;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class TransactionRequest {
    @NotNull(message = "Amount is required.")
    private BigDecimal amount;
}
