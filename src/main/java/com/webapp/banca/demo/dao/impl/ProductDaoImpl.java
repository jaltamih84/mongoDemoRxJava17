package com.webapp.banca.demo.dao.impl;

import com.webapp.banca.demo.dao.ProductDao;
import com.webapp.banca.demo.dao.repository.ProductRepository;
import com.webapp.banca.demo.model.entity.ProductEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.adapter.rxjava.RxJava3Adapter;

@Service
public class ProductDaoImpl implements ProductDao {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Maybe<ProductEntity> insert(ProductEntity productEntity) {
        return RxJava3Adapter.monoToMaybe(this.productRepository.insert(productEntity));
    }

    @Override
    public Flowable<ProductEntity> findAll() {
        return RxJava3Adapter.fluxToFlowable(this.productRepository.findAll());
    }

    @Override
    public Maybe<ProductEntity> findById(String productId) {
        return RxJava3Adapter.monoToMaybe(this.productRepository.findById(productId));
    }
}
