package com.webapp.banca.demo.dao.impl;

import com.webapp.banca.demo.dao.ClientDao;
import com.webapp.banca.demo.dao.repository.ClientRepository;
import com.webapp.banca.demo.model.entity.ClientEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.adapter.rxjava.RxJava3Adapter;

@Service
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Maybe<ClientEntity> insert(ClientEntity clientEntity) {
        return RxJava3Adapter.monoToMaybe(this.clientRepository.insert(clientEntity));
    }

    @Override
    public Flowable<ClientEntity> findAll() {
        return RxJava3Adapter.fluxToFlowable(this.clientRepository.findAll());
    }

    @Override
    public Maybe<ClientEntity> findById(String clientId) {
        return RxJava3Adapter.monoToMaybe(this.clientRepository.findById(clientId));
    }
}
