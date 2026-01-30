package com.eyewear.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customeraccount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "username", unique = true)
    private String username;

    // @Column(name = "password_hash")
    // private String passwordHash;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;
}