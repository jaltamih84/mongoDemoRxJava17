package com.webapp.banca.demo.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class ProductEntity {
    @Id
    private String id;
    private String code;
    private String description;
    private int type;
    private int active;
}
