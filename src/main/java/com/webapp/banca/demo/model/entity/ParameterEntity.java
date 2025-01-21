package com.webapp.banca.demo.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parametro")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class ParameterEntity {
    @Id
    private String id;
    private String clave;
    private String valor;
    private String fechaActualizacion;

}