package com.singlestone.petstore.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Product implements Serializable {
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Price")
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getPriceAsFloat(){
        return Float.parseFloat(getPrice());
    }
}
