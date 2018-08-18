package com.singlestone.petstore.product.model;

import java.util.Optional;

public interface IProductManager {
    Optional<Product> getProductById(String id);
}
