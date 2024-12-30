package com.webapp.banca.demo.dao.repository;

import com.webapp.banca.demo.model.entity.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
}
