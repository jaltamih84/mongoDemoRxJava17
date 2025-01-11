package com.webapp.banca.demo.model.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "parametro")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class ParameterEntity {
    @Id
    @SerializedName("id")
    private String id;
    @SerializedName("clave")
    private String clave;
    @SerializedName("valor")
    private String valor;
    @SerializedName("fechaActualizacion")
    private String fechaActualizacion;

}