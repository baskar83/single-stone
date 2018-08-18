package com.singlestone.petstore.orderentry.service;

import com.singlestone.petstore.orderentry.exception.OrderNotFound;
import com.singlestone.petstore.orderentry.model.OrderEntry;
import com.singlestone.petstore.orderentry.repository.IOrderEntryRepository;
import com.singlestone.petstore.orderentry.valueobject.ItemDetailVO;
import com.singlestone.petstore.orderentry.valueobject.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetail implements IOrderDetail{

    @Autowired
    private IOrderEntryRepository orderEntryRepository;

    @Override
    public OrderDetailVO detailByCustomer(String customerId) {
        List<OrderEntry> orderEntries = orderEntryRepository.findByOrderEntryId_CustomerId(customerId);
        if(orderEntries.isEmpty()){
            throw new OrderNotFound("No order found for customer id " + customerId);
        }
        OrderDetailVO orderDetailVO = OrderDetailVO.create(customerId);
        float grandTotal = 0;
        for(OrderEntry orderEntry : orderEntries){
            ItemDetailVO itemDetailVO = ItemDetailVO.create(orderEntry);
            orderDetailVO.addItemDetail(itemDetailVO);
            grandTotal += orderEntry.getTotal();
        }
        orderDetailVO.setGrandTotal(grandTotal);
        return orderDetailVO;
    }
}
