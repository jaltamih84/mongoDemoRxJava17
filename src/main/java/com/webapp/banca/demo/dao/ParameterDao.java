package com.webapp.banca.demo.dao;

import com.webapp.banca.demo.model.entity.ParameterEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ParameterDao {
    Maybe<ParameterEntity> insert(ParameterEntity parameter);

    Flowable<ParameterEntity> findAll();

    Maybe<ParameterEntity> findById(String parameterId);
}
