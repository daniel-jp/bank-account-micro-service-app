package com.danny.customer_service.web;

import com.danny.customer_service.entities.Customer;
import com.danny.customer_service.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping("/customers")
public class RestCustomerController {

    private CustomerRepository customerRepository;

    public RestCustomerController (CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
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


    @PutMapping("/{id}")
    public Customer updateEmployer(@PathVariable Long id, @RequestBody Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null;
    }
}
