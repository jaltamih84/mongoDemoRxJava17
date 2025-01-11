package com.webapp.banca.demo.model.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Parameter {
    private String parametroId;
    private String clave;
    private String valor;
    private String fechaActualizacion;
}
