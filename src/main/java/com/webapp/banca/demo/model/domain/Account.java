package com.webapp.banca.demo.model.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Account {
    private String id;
    private String number;
    private String productCode;
    private int flagComision;
    private int maxOperation;
    private String startDate;
    private String endDate;
    private BigDecimal balance;
    private String currency;
    private int active;
}
