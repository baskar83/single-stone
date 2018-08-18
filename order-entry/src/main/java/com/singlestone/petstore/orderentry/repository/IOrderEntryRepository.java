package com.singlestone.petstore.orderentry.repository;

import com.singlestone.petstore.orderentry.model.OrderEntry;
import com.singlestone.petstore.orderentry.model.OrderEntryId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrderEntryRepository extends CrudRepository<OrderEntry, OrderEntryId> {
    List<OrderEntry> findByOrderEntryId_CustomerId(String customerId);
}
