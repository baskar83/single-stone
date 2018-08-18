package com.singlestone.petstore.orderentry.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailVO {
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("grandTotal")
    private String grandTotal;
    @JsonProperty("items")
    private List<ItemDetailVO> items;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<ItemDetailVO> getItems() {
        return items;
    }

    public void setItems(List<ItemDetailVO> items) {
        this.items = items;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = String.format("%.2f", grandTotal);
    }

    public void addItemDetail(ItemDetailVO itemDetailVO){
        getItems().add(itemDetailVO);
    }

    public static OrderDetailVO create(String customerId){
        OrderDetailVO order = new OrderDetailVO();
        order.setCustomerId(customerId);
        order.setItems(new ArrayList<>());
        return order;
    }
}
