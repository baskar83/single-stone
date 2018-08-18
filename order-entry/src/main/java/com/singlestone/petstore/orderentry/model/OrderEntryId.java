package com.singlestone.petstore.orderentry.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderEntryId implements Serializable {

    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "product_id")
    private String productId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public static OrderEntryId create(String customerId, String productId){
        OrderEntryId id = new OrderEntryId();
        id.setCustomerId(customerId);
        id.setProductId(productId);
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntryId that = (OrderEntryId) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customerId, productId);
    }
}
