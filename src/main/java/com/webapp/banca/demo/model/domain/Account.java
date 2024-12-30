package com.webapp.banca.demo.model.domain;

import lombok.*;

import java.util.TimeZone;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Account {
    private String number;
    private String productCode;
    private int flagComision;
    private int maxOperation;
    private TimeZone startDate;
    private TimeZone endDate;
    private Double balance;
    private String currency;
    private int active;
}
