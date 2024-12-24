package com.webapp.banca.demo.dao.repository;

import com.webapp.banca.demo.model.entity.ClientEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<ClientEntity, String> {

}
