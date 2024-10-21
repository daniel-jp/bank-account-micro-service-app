package com.danny.account_service;

import com.danny.account_service.clients.CustomerRestClient;
import com.danny.account_service.entities.BankAccount;
import com.danny.account_service.enums.AccountType;
import com.danny.account_service.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}



	@Bean
	CommandLineRunner commandLineRunner (BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
		return  args -> {

			customerRestClient.allCustomers().forEach(customer -> {

				BankAccount account1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*70000)
						.createAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(customer.getId())
						.build();

				BankAccount account2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*80000)
						.createAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(customer.getId())
						.build();




				accountRepository.save(account1);
				accountRepository.save(account2);
			});

		};
	}
}
