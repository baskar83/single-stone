package com.singlestone.petstore.product.model;

import com.singlestone.petstore.product.rest.client.IProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
class ProductManager implements IProductManager{

    @Autowired
    private IProductInventoryService productInventoryService;

    public Optional<Product> getProductById(String id){
        Map<String, Product> productMap = productInventoryService.getProductMap();
        Optional<Product> product = Optional.empty();
        if(productMap.containsKey(id)){
            product = Optional.of(productMap.get(id));
        }
        return product;
    }
}
