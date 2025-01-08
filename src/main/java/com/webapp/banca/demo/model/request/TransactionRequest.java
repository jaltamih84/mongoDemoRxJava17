package com.webapp.banca.demo.model.request;


import lombok.*;

import javax.validation.constraints.NotNull;
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
