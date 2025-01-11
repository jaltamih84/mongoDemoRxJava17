package com.webapp.banca.demo.expose.mapper;

import com.webapp.banca.demo.model.domain.Parameter;
import com.webapp.banca.demo.model.entity.ParameterEntity;
import org.springframework.stereotype.Component;

@Component
public class ParameterMapper {

    public ParameterEntity getParameterEntityInsertOfParameter(Parameter parameter) {
        return ParameterEntity.builder()
                .id(parameter.getParametroId())
                .clave(parameter.getClave())
                .valor(parameter.getValor())
                .fechaActualizacion(parameter.getFechaActualizacion())
                .build();
    }

    public Parameter getParameterOfParameterEntity(ParameterEntity parameterEntity) {
        return Parameter.builder()
                .parametroId(parameterEntity.getId())
                .clave(parameterEntity.getClave())
                .valor(parameterEntity.getValor())
                .fechaActualizacion(parameterEntity.getFechaActualizacion())
                .build();
    }
}
