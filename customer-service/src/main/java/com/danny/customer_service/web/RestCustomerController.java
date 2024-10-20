package com.danny.customer_service.web;

import com.danny.customer_service.entities.Customer;
import com.danny.customer_service.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3000")
public class RestCustomerController {

    private CustomerRepository customerRepository;

    public RestCustomerController (CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id /*HttpServletRequest request*/){
        //System.out.println("Request URL: " + request.getRequestURL());
        return customerRepository.findById(id).get();
                //.orElseThrow(()-> new RuntimeException("ERROR"));
    }
}
