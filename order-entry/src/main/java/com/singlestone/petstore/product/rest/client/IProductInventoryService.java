package com.singlestone.petstore.product.rest.client;

import com.singlestone.petstore.product.model.Product;

import java.util.Map;

public interface IProductInventoryService {
    Map<String, Product> getProductMap();
    Product getProductById(String productId);
}
