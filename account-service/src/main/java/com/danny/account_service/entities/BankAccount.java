package com.danny.account_service.entities;

import com.danny.account_service.enums.AccountType;
import com.danny.account_service.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;
import java.time.LocalDate;
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Builder
public class BankAccount {

    @Id
    private String accountId;
    private double balance ;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
