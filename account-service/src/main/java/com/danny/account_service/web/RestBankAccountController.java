package com.danny.account_service.web;

import com.danny.account_service.clients.CustomerRestClient;
import com.danny.account_service.entities.BankAccount;
import com.danny.account_service.model.Customer;
import com.danny.account_service.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RestBankAccountController {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public RestBankAccountController (BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){

        List<BankAccount> accountList =  accountRepository.findAll();

        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });

        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){

         BankAccount account = accountRepository.findById(id).get();

        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);

        return account;
    }
}
