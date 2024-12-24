package com.webapp.banca.demo.model.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Client {
    private String clientId;
    private String account;
    private ClientType type;
    private Person person;
    private int active;
}
