package com.singlestone.petstore.orderentry.model;

import com.singlestone.petstore.orderentry.valueobject.OrderVO;
import com.singlestone.petstore.orderentry.valueobject.ProductQuantityVO;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "OrderEntry")
@Table(name = "order_entry")
public class OrderEntry {

    @EmbeddedId
    private OrderEntryId orderEntryId;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private float price;

    public OrderEntryId getOrderEntryId() {
        return orderEntryId;
    }

    public void setOrderEntryId(OrderEntryId orderEntryId) {
        this.orderEntryId = orderEntryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static OrderEntry create(OrderVO orderVO, ProductQuantityVO productQuantityVO){
        OrderEntry entry = new OrderEntry();
        OrderEntryId id = OrderEntryId.create(orderVO.getCustomerId(), productQuantityVO.getProductId());
        entry.setOrderEntryId(id);
        entry.setQuantity(productQuantityVO.getQuantity());
        return entry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotal(){
        return quantity * price;
    }

}
