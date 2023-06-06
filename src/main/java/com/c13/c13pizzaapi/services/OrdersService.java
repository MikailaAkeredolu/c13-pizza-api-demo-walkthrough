package com.c13.c13pizzaapi.services;

import com.c13.c13pizzaapi.models.Customer;
import com.c13.c13pizzaapi.models.Orders;
import com.c13.c13pizzaapi.repos.CustomerRepo;
import com.c13.c13pizzaapi.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    public void addOrder(Long customerId, Orders order){
        //we need to find the customer by id
        Customer customer = customerRepo.findById(customerId).orElse(null);
        //setting the order as the customer's order
        order.setCustomer(customer);
        //save the order for customer with specific id
        ordersRepo.save(order);

    }

    public List<Orders> getAllOrdersByCustomerId(Long customerId){
       return ordersRepo.findAllOrdersByCustomerId(customerId);
    }

    public void updateOrder(Long customerId, Long ordersId, Orders order){
        Customer customer = customerRepo.findById(customerId).orElse(null);
        Orders o = ordersRepo.findById(ordersId).orElse(null);
        if( o != null){
           o.setCrust(order.getCrust());
           o.setToppings(order.getToppings());
        }
        order.setCustomer(customer);
        ordersRepo.save(order);

    }


    public void deleteOrder(Long orderId ){
        ordersRepo.deleteById(orderId);
    }

    public Orders getOrderById(Long id){
        return ordersRepo.findById(id).orElse(null);
    }






}
