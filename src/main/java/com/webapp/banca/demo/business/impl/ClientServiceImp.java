package com.webapp.banca.demo.business.impl;

import com.webapp.banca.demo.business.ClientService;
import com.webapp.banca.demo.dao.ClientDao;
import com.webapp.banca.demo.expose.mapper.ClientMapper;
import com.webapp.banca.demo.model.domain.Client;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Maybe<Client> insert(Client client) {
        return this.clientDao.insert(this.clientMapper.getClientEntityInsertOfClient(client))
                .map(this.clientMapper::getClientOfClientEntity);
    }

    @Override
    public Maybe<Client> findById(String clientId) {
        return this.clientDao.findById(clientId)
                .map(this.clientMapper::getClientOfClientEntity);
    }

    @Override
    public Flowable<Client> findAll() {
        return this.clientDao.findAll().map(this.clientMapper::getClientOfClientEntity);
    }
}
