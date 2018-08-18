package com.singlestone.petstore.orderentry.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.singlestone.petstore.orderentry.model.OrderEntry;

public class ItemDetailVO {
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("price")
    private String price;
    @JsonProperty("total")
    private String total;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = String.format("%.2f", price);
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = String.format("%.2f", total);
    }

    public static ItemDetailVO create(OrderEntry orderEntry){
        ItemDetailVO detailVO = new ItemDetailVO();
        detailVO.setName(orderEntry.getName());
        detailVO.setPrice(orderEntry.getPrice());
        detailVO.setProductId(orderEntry.getOrderEntryId().getProductId());
        detailVO.setTotal(orderEntry.getTotal());
        detailVO.setQuantity(orderEntry.getQuantity());
        return detailVO;
    }
}
