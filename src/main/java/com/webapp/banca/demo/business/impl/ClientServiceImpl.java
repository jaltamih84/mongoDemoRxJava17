package com.webapp.banca.demo.business.impl;

import com.webapp.banca.demo.business.ClientService;
import com.webapp.banca.demo.dao.ClientDao;
import com.webapp.banca.demo.expose.mapper.ClientMapper;
import com.webapp.banca.demo.model.domain.Client;
import com.webapp.banca.demo.model.domain.ClientType;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Maybe<Client> insert(Client client) {
        logger.info("Processing service insert()");
        return this.clientDao.insert(this.clientMapper.getClientEntityInsertOfClient(client))
                .map(this.clientMapper::getClientOfClientEntity);
    }

    @Override
    public Maybe<Client> findById(String clientId) {
        logger.info("Processing service findById()");
        return this.clientDao.findById(clientId)
                .map(this.clientMapper::getClientOfClientEntity);
    }

    @Override
    public Flowable<Client> findAll() {
        logger.info("Processing service findAll()");
        return this.clientDao.findAll()
                .map(this.clientMapper::getClientOfClientEntity);
    }

    @Override
    public Flowable<ClientType> getClientsByTypeCode() {
        return clientDao.findByClientTypeCodeIn(Arrays.asList(1, 2))
                .map(this.clientMapper::getClientTypeOfClientEntity)
                .distinct();
    }


}
