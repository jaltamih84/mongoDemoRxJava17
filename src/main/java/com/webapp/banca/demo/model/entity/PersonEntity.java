package com.webapp.banca.demo.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class PersonEntity {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private int documentType;
  private Long documentNumber;
  private int age;
  private String emeal;
  private String statusCivil;
}
