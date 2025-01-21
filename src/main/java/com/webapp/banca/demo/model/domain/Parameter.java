package com.webapp.banca.demo.model.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.WRAPPER_OBJECT // Cambiar WRAPPER_ARRAY por WRAPPER_OBJECT si aplica
)
public class Parameter {
    private String id;
    private String clave;
    private String valor;
    private String fechaActualizacion;
}
