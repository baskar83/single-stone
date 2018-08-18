package com.singlestone.petstore.orderentry.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderSummaryVO {
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("orderCount")
    private int orderCount;
    @JsonProperty("itemsCount")
    private int itemsCount;
    @JsonProperty("grandTotal")
    private String grandTotal;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = String.format("%.2f", grandTotal);
    }

    public static OrderSummaryVO create(String customerId){
        OrderSummaryVO summaryVO = new OrderSummaryVO();
        summaryVO.setCustomerId(customerId);
        return summaryVO;
    }
}
