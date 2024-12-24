package com.webapp.banca.demo.model.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Document {
  private int type;
  private int number;
}
