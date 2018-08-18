package com.singlestone.petstore.orderentry.service;

import com.singlestone.petstore.orderentry.exception.OrderNotFound;
import com.singlestone.petstore.orderentry.model.OrderEntry;
import com.singlestone.petstore.orderentry.repository.IOrderEntryRepository;
import com.singlestone.petstore.orderentry.valueobject.OrderSummaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class OrderSummary implements IOrderSummary{

    @Autowired
    private IOrderEntryRepository orderEntryRepository;

    @Override
    public OrderSummaryVO summaryByCustomer(String customerId) {
        List<OrderEntry> orderEntries = orderEntryRepository.findByOrderEntryId_CustomerId(customerId);
        if(orderEntries.isEmpty()){
            throw new OrderNotFound("No order found for customer id " + customerId);
        }
        OrderSummaryVO summaryVO = OrderSummaryVO.create(customerId);
        float grandTotal = 0;
        int itemCount = 0;
        for(OrderEntry orderEntry : orderEntries){
            grandTotal += orderEntry.getTotal();
            itemCount += orderEntry.getQuantity();
        }
        summaryVO.setOrderCount(orderEntries.size());
        summaryVO.setItemsCount(itemCount);
        summaryVO.setGrandTotal(grandTotal);
        return summaryVO;
    }
}
