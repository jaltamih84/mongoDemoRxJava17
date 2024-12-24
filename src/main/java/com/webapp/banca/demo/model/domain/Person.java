package com.webapp.banca.demo.model.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Person {
  private String personaId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private Document document;
  private int age;
  private String emeal;
  private String statusCivil;
}