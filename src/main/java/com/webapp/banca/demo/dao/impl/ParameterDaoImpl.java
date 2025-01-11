package com.webapp.banca.demo.dao.impl;

import com.webapp.banca.demo.dao.ParameterDao;
import com.webapp.banca.demo.dao.repository.ParameterRepository;
import com.webapp.banca.demo.model.entity.ParameterEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.adapter.rxjava.RxJava3Adapter;

@Service
public class ParameterDaoImpl implements ParameterDao {
    @Autowired
    ParameterRepository parameterRepository;

    @Override
    public Maybe<ParameterEntity> insert(ParameterEntity parameterEntity) {
        return RxJava3Adapter.monoToMaybe(this.parameterRepository.insert(parameterEntity));
    }

    @Override
    public Flowable<ParameterEntity> findAll() {
        return RxJava3Adapter.fluxToFlowable(this.parameterRepository.findAll());
    }

    @Override
    public Maybe<ParameterEntity> findById(String parameterId) {
        return RxJava3Adapter.monoToMaybe(this.parameterRepository.findById(parameterId));
    }
}
