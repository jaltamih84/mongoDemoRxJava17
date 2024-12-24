package com.webapp.banca.demo.business;

import com.webapp.banca.demo.model.domain.Client;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ClientService {
    Maybe<Client> insert (Client client);
    Maybe<Client> findById (String clientId);
    Flowable<Client> findAll ();
}
