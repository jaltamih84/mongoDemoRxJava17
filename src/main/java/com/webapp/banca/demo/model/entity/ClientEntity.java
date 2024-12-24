package com.webapp.banca.demo.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class ClientEntity {
    @Id
    private String id;
    private String account;
    private int clientTypeCode;
    private String clientTypeDescription;
    private String pPersonaId;
    private String pFirstName;
    private String pLastName;
    private String pPhoneNumber;
    private int documentType;
    private int documentNumber;
    private int pAge;
    private String pEmeal;
    private String pStatusCivil;
    private int active;
}
