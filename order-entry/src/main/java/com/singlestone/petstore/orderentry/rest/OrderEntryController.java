package com.singlestone.petstore.orderentry.rest;

import com.singlestone.petstore.orderentry.service.IOrderDetail;
import com.singlestone.petstore.orderentry.service.IOrderSummary;
import com.singlestone.petstore.orderentry.service.IReceiveOrder;
import com.singlestone.petstore.orderentry.valueobject.OrderDetailVO;
import com.singlestone.petstore.orderentry.valueobject.OrderSummaryVO;
import com.singlestone.petstore.orderentry.valueobject.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/entry")
public class OrderEntryController {

    @Autowired
    private IReceiveOrder receiveOrder;

    @PostMapping
    public void receiveOrder(@RequestBody OrderVO orderVO){
        receiveOrder.process(orderVO);
    }

    @Autowired
    private IOrderDetail orderDetail;

    @RequestMapping(path = "/detail/{customerId}", method = RequestMethod.GET)
    public OrderDetailVO orderDetail(@PathVariable String customerId){
        return orderDetail.detailByCustomer(customerId);
    }

    @Autowired
    private IOrderSummary orderSummary;

    @RequestMapping(path = "/summary/{customerId}", method = RequestMethod.GET)
    public OrderSummaryVO orderSummary(@PathVariable String customerId){
        return orderSummary.summaryByCustomer(customerId);
    }
}
