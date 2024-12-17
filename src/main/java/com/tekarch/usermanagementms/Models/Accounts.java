package com.tekarch.usermanagementms.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Data
public class Accounts {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false, unique = true, length = 20)
    private String accountNumber;

    @Column(nullable = false, length = 20)
    private String accountType;

    @Column(nullable = false, columnDefinition = "DECIMAL(15, 2) DEFAULT 0.0")
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'USD'")
    private String currency = "USD";

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}
