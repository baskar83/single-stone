package com.singlestone.petstore.product.rest.client;

import com.singlestone.petstore.product.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
class ProductInventoryService implements IProductInventoryService {

    @Value("${petstore.products.url}")
    private String endpoint;
    private RestTemplate restTemplate;

    public ProductInventoryService(){
        restTemplate = new RestTemplate();
    }


    private List<Product> getProductList() {
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                endpoint, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();
    }

    @Cacheable("inventory")
    @Override
    public Map<String, Product> getProductMap(){
        Map<String, Product> productMap = new HashMap<>();
        getProductList()
                .stream()
                .forEach(p -> productMap.put(p.getId(), p));
        return productMap;
    }

    @Override
    public Product getProductById(String productId) {
        ResponseEntity<Product> response = restTemplate.exchange(
                endpoint + productId,
                HttpMethod.GET, HttpEntity.EMPTY,
                Product.class);
        return response.getBody();
    }
}
