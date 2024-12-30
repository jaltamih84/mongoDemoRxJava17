package com.webapp.banca.demo.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class AccountEntity {
    @Id
    private String id;
    private String number;
    private String productCode;
    private int flagComision;
    private int maxOperation;
    private String startDate;
    private String endDate;
    private Double balance;
    private String currency;
    private int active;

}
