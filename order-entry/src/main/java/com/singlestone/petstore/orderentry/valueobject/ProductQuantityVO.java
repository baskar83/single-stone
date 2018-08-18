package com.singlestone.petstore.orderentry.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductQuantityVO {
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("quantity")
    private int quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
