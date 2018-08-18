package com.singlestone.petstore.orderentry.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderVO {
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("items")
    private List<ProductQuantityVO> items;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<ProductQuantityVO> getItems() {
        return items;
    }

    public void setItems(List<ProductQuantityVO> items) {
        this.items = items;
    }
}
