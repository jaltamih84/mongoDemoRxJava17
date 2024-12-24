package com.webapp.banca.demo.model.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class ClientType {
    private int code;
    private String description;
}
