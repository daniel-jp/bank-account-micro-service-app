package com.danny.customer_service;

import com.danny.customer_service.config.GlobalConfig;
import com.danny.customer_service.entities.Customer;
import com.danny.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){

		return args -> {

			List<Customer> customerList=List.of(

					Customer.builder()
							.firstName("Danny")
							.lastName("Paulino")
							.email("danny@gmail.com")
							.build(),

					Customer.builder()
							.firstName("Benny")
							.lastName("Liatunga")
							.email("benny@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);




		};
	}
}
