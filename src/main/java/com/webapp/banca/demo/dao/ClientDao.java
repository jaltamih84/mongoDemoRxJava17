package com.webapp.banca.demo.dao;

import com.webapp.banca.demo.model.domain.Client;
import com.webapp.banca.demo.model.domain.ClientType;
import com.webapp.banca.demo.model.entity.ClientEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ClientDao {
    Maybe<ClientEntity> insert(ClientEntity client);
    Flowable<ClientEntity> findAll();
    Maybe<ClientEntity> findById(String clientId);

    Flowable<ClientEntity> findByClientTypeCodeIn(List<Integer> list);
}
