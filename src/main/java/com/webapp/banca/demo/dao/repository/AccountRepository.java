package com.webapp.banca.demo.dao.repository;

import com.webapp.banca.demo.model.entity.AccountEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepository extends ReactiveMongoRepository<AccountEntity, String> {
}
