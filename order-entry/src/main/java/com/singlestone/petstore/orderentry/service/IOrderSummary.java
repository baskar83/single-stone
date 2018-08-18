package com.singlestone.petstore.orderentry.service;

import com.singlestone.petstore.orderentry.valueobject.OrderSummaryVO;

public interface IOrderSummary {
    OrderSummaryVO summaryByCustomer(String customerId);
}
