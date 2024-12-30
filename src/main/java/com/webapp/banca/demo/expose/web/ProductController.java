package com.webapp.banca.demo.expose.web;

import com.webapp.banca.demo.business.ProductService;
import com.webapp.banca.demo.model.domain.Product;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank/")
@Slf4j
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(value = "product/{productId}",
            produces = {"application/json"})
    public Maybe<Product> getProduct(@PathVariable String productId) {
        logger.info("Processing request for /api/bank/product/{productId}");
        return this.productService.findById(productId);
    }

    @GetMapping(value = "/products",
            produces = {"application/json"})
    public Flowable<Product> getProducts() {
        logger.info("Procesando la solicitud para /api/bank/products");
        return this.productService.findAll();
    }

    @PostMapping(value = "/product",
            produces = {"application/json"})
    public Maybe<Product> postProduct(@RequestBody Product product) {
        logger.info("Procesando la solicitud para /api/bank/product");
        return this.productService.insert(product);
    }
}
