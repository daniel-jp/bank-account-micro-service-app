package com.danny.account_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {

    private Long id;
    private String firstname;
    private String lastName;
    private String email;
}
