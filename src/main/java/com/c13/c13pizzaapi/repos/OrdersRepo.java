package com.c13.c13pizzaapi.repos;

import com.c13.c13pizzaapi.models.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends CrudRepository<Orders, Long> {
 //find all orders by the customer's id
    List<Orders> findAllOrdersByCustomerId(Long customerId);
}
