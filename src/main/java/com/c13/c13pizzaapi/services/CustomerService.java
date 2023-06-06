package com.c13.c13pizzaapi.services;

import com.c13.c13pizzaapi.models.Customer;
import com.c13.c13pizzaapi.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepo customerRepo;


    //create a customer
    public void addCustomer(Customer customer){
        customerRepo.save(customer);
    }

    //get all customers
    public Iterable<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    // get a customer by id
    public Optional<Customer> getCustomerById(Long id){
        return customerRepo.findById(id);
    }

    //update a customer by id
    public void updateCustomer(Long id, Customer customer){
        customer.setId(id);
        customerRepo.save(customer);
    }

    //delete a customer
    public void deleteCustomer(Long id){
        customerRepo.deleteById(id);
    }


     /*
    find a customer by their name
    name of the customer will be needed when we check if customer exist

     */

    public Customer findACustomerByName(String name){
     return customerRepo.findByName(name);
    }


}
