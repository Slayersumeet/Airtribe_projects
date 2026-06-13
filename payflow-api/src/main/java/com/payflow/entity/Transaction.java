package com.payflow.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String senderUpiId;

    @Column(nullable = false)
    private String receiverUpiId;

    @Column(nullable = false)
    private Double amount;

    private String status;
    private LocalDateTime createdAt;

    public Transaction() {}

    public Transaction(String senderUpiId, String receiverUpiId, Double amount) {
        this.senderUpiId = senderUpiId;
        this.receiverUpiId = receiverUpiId;
        this.amount = amount;
        this.status = "SUCCESS";
        this.createdAt = LocalDateTime.now();
    }

    public Long getId()                 { return id; }
    public String getSenderUpiId()      { return senderUpiId; }
    public String getReceiverUpiId()    { return receiverUpiId; }
    public Double getAmount()           { return amount; }
    public String getStatus()           { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setSenderUpiId(String s)      { this.senderUpiId = s; }
    public void setReceiverUpiId(String r)    { this.receiverUpiId = r; }
    public void setAmount(Double amount)      { this.amount = amount; }
    public void setStatus(String status)      { this.status = status; }
    public void setCreatedAt(LocalDateTime t) { this.createdAt = t; }
}
