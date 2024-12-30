package com.webapp.banca.demo.dao;

import com.webapp.banca.demo.model.entity.ProductEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ProductDao {
    Maybe<ProductEntity> insert(ProductEntity product);
    Flowable<ProductEntity> findAll();
    Maybe<ProductEntity> findById(String productId);
}
