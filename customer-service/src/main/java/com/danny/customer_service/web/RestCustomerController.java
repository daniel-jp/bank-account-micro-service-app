package com.danny.customer_service.web;

import com.danny.customer_service.entities.Customer;
import com.danny.customer_service.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customers")
public class RestCustomerController {

    private CustomerRepository customerRepository;

    public RestCustomerController (CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @GetMapping
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id /*HttpServletRequest request*/){
        //System.out.println("Request URL: " + request.getRequestURL());
        return customerRepository.findById(id).get();
                //.orElseThrow(()-> new RuntimeException("ERROR"));
    }
}
