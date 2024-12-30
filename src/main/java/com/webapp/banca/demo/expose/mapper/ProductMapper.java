package com.webapp.banca.demo.expose.mapper;

import com.webapp.banca.demo.model.domain.Product;
import com.webapp.banca.demo.model.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapper {

    public ProductEntity getProductEntityInsertOfProduct(Product product) {
        return ProductEntity.builder()
                .id(UUID.randomUUID().toString())
                .code(product.getCode())
                .description(product.getDescription())
                .type(product.getType())
                .active(product.getActive())
                .build();
    }

    public Product getProductOfProductEntity(ProductEntity productEntity) {
        return Product.builder()
                .productId(productEntity.getId())
                .code(productEntity.getCode())
                .description(productEntity.getDescription())
                .type(productEntity.getType())
                .active(productEntity.getActive())
                .build();
    }
}
