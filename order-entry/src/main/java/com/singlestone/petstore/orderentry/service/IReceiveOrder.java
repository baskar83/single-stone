package com.singlestone.petstore.orderentry.service;

import com.singlestone.petstore.orderentry.valueobject.OrderVO;

public interface IReceiveOrder {
    void process(OrderVO orderVO);
}
