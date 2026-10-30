package com.banking.account_service.dto;

import java.math.BigDecimal;

public class CreateAccountRequest {


    @Data
    @NoArgsConstrutor
    @AllArgsConstructor

    public class AccountResponse {


        @NotBlank(message = "Account holder name is require")
        private String accountHolerName;

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        private String email;

        @NotBlank(message = "phone is required")
        private String phone;

        @NotNull(message = "Account type is required")
        private AccountType accountType;

        @NotNull(message = "Initial deposit is required")
        @Positive(message = "Initial deposit must be positive")
        private BigDecimal initialDeposit;


    }
