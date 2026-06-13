package com.payflow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // "user" is reserved in H2 SQL, so we name the table "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String upiId;

    private String phoneNumber;
    private Double balance;

    public User() {}

    public User(String name, String upiId, String phoneNumber, Double balance) {
        this.name = name;
        this.upiId = upiId;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public Long getId()            { return id; }
    public String getName()        { return name; }
    public String getUpiId()       { return upiId; }
    public String getPhoneNumber() { return phoneNumber; }
    public Double getBalance()     { return balance; }

    public void setName(String name)               { this.name = name; }
    public void setUpiId(String upiId)             { this.upiId = upiId; }
    public void setPhoneNumber(String p)           { this.phoneNumber = p; }
    public void setBalance(Double balance)         { this.balance = balance; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', upiId='" + upiId + "', balance=" + balance + "}";
    }
}
