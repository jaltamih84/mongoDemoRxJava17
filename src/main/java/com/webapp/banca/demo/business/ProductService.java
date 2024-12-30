package com.webapp.banca.demo.business;

import com.webapp.banca.demo.model.domain.Product;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface ProductService {
    Maybe<Product> insert(Product product);
    Maybe<Product> findById(String productId);
    Flowable<Product> findAll();
}
