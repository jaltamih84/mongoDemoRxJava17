package com.webapp.banca.demo.expose.mapper;

import com.webapp.banca.demo.expose.util.Utilitary;
import com.webapp.banca.demo.model.domain.Parameter;
import com.webapp.banca.demo.model.entity.ParameterEntity;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class ParameterMapper {

    public ParameterEntity getParameterEntityInsertOfParameter(Parameter parameter) {
        return ParameterEntity.builder()
                .id(UUID.randomUUID().toString())
                .clave(parameter.getClave())
                .valor(parameter.getValor())
                .fechaActualizacion(Utilitary.getStringFromDateFormat(new Date()))
                .build();
    }

    public Parameter getParameterOfParameterEntity(ParameterEntity parameterEntity) {
        return Parameter.builder()
                .id(parameterEntity.getId())
                .clave(parameterEntity.getClave())
                .valor(parameterEntity.getValor())
                .fechaActualizacion(parameterEntity.getFechaActualizacion())
                .build();
    }
}
