package com.webapp.banca.demo.business.impl;

import com.webapp.banca.demo.business.ProductService;
import com.webapp.banca.demo.dao.ProductDao;
import com.webapp.banca.demo.expose.mapper.ProductMapper;
import com.webapp.banca.demo.model.domain.Product;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Maybe<Product> insert(Product product) {
        logger.info("Processing service ProductServiceImpl.insert()");
        return this.productDao.insert(this.productMapper.getProductEntityInsertOfProduct(product))
                .map(this.productMapper::getProductOfProductEntity);
    }

    @Override
    public Maybe<Product> findById(String productId) {
        logger.info("Processing service ProductServiceImpl.findById()");
        return this.productDao.findById(productId).map(this.productMapper::getProductOfProductEntity);
    }

    @Override
    public Flowable<Product> findAll() {
        logger.info("Processing service ProductServiceImpl.findAll()");
        return this.productDao.findAll().map(this.productMapper::getProductOfProductEntity);
    }


}
