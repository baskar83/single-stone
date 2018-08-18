package com.singlestone.petstore.orderentry.service;

import com.singlestone.petstore.product.model.IProductManager;
import com.singlestone.petstore.product.model.Product;
import com.singlestone.petstore.orderentry.exception.ProductNotFound;
import com.singlestone.petstore.orderentry.model.OrderEntry;
import com.singlestone.petstore.orderentry.repository.IOrderEntryRepository;
import com.singlestone.petstore.orderentry.valueobject.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class ReceiveOrder implements IReceiveOrder {

    @Autowired
    private IProductManager productManager;

    @Autowired
    private IOrderEntryRepository orderEntryRepository;

    @Override
    public void process(OrderVO orderVO) {
        List<OrderEntry> orderEntries = new ArrayList<>(orderVO.getItems().size());
        orderVO.getItems().forEach(productQuantityVO -> {
            Optional<Product> optPrd = productManager.getProductById(productQuantityVO.getProductId());
            Product product = optPrd.orElseThrow(() ->
                    new ProductNotFound("Invalid Product Id " + productQuantityVO.getProductId()));
            OrderEntry entry = OrderEntry.create(orderVO, productQuantityVO);
            entry.setPrice(product.getPriceAsFloat());
            entry.setName(product.getName());
            orderEntries.add(entry);

        });
        orderEntryRepository.saveAll(orderEntries);
    }
}
