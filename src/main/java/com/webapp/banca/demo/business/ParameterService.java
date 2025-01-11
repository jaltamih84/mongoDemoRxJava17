package com.webapp.banca.demo.business;

import com.webapp.banca.demo.model.domain.Parameter;
import com.webapp.banca.demo.model.entity.ParameterEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ParameterService {
    Maybe<Parameter> insert(Parameter parameter);
    Maybe<Parameter> findById(String parameterId);
    Flowable<Parameter> findAll();
    Flowable<ParameterEntity> findAllParameterEntity();
}

