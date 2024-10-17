package com.danny.account_service.clients;

import com.danny.account_service.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById (@PathVariable Long id);


    @GetMapping("/accounts")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomer")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id,  Exception exception){

        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not valable");
        customer.setLastName("Not valable");
        customer.setEmail("Not valable");
        return  customer;
    }

    default List<Customer> getAllCustomers(Exception exception){

        return List.of();
    }
}
