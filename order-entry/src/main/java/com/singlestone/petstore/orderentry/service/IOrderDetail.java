package com.singlestone.petstore.orderentry.service;

import com.singlestone.petstore.orderentry.valueobject.OrderDetailVO;

public interface IOrderDetail {
    OrderDetailVO detailByCustomer(String customerId);
}
