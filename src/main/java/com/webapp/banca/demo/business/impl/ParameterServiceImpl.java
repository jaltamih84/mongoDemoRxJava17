package com.webapp.banca.demo.business.impl;

import com.webapp.banca.demo.business.ParameterService;
import com.webapp.banca.demo.dao.ParameterDao;
import com.webapp.banca.demo.expose.mapper.ParameterMapper;
import com.webapp.banca.demo.model.domain.Parameter;
import com.webapp.banca.demo.model.entity.ParameterEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterServiceImpl implements ParameterService {
    private static final Logger logger = LoggerFactory.getLogger(ParameterServiceImpl.class);

    @Autowired
    private ParameterDao parameterDao;

    @Autowired
    private ParameterMapper parameterMapper;

    @Override
    public Maybe<Parameter> insert(Parameter parameter) {
        logger.info("Processing service ParameterServiceImpl.insert()");
        return this.parameterDao.insert(this.parameterMapper.getParameterEntityInsertOfParameter(parameter))
                .map(this.parameterMapper::getParameterOfParameterEntity);
    }

    @Override
    public Maybe<Parameter> findById(String parameterId) {
        logger.info("Processing service ParameterServiceImpl.findById()");
        return this.parameterDao.findById(parameterId).map(this.parameterMapper::getParameterOfParameterEntity);
    }

    @Override
    public Flowable<Parameter> findAll() {
        logger.info("Processing service ParameterServiceImpl.findAll()");
        return this.parameterDao.findAll().map(this.parameterMapper::getParameterOfParameterEntity);
    }

    @Override
    public Flowable<ParameterEntity> findAllParameterEntity() {
         logger.info(":::::Processing service ParameterServiceImpl.findAllParameterEntity()");
        return this.parameterDao.findAll();
    }


}
