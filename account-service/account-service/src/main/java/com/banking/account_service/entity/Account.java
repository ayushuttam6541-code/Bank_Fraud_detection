package com.banking.account_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;


@Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal balance;

 @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal dailyTransactionLimit;

 @CreationTimestamp
    private LocalDateTime createdAt;

 @UpdateTimestamp
    private LocalDateTime updatedAt;

}
