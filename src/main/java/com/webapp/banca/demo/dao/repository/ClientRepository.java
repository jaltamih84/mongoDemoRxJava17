package com.webapp.banca.demo.dao.repository;

import com.webapp.banca.demo.model.domain.Client;
import com.webapp.banca.demo.model.entity.ClientEntity;
import com.webapp.banca.demo.model.entity.PersonEntity;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ClientRepository extends ReactiveMongoRepository<ClientEntity, String> {

    Flux<ClientEntity> findByClientTypeCodeIn(List<Integer> clientTypeCodes);
}
