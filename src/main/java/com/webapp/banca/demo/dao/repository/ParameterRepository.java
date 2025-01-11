package com.webapp.banca.demo.dao.repository;

import com.webapp.banca.demo.model.entity.ParameterEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ParameterRepository extends ReactiveMongoRepository<ParameterEntity, String> {
}
