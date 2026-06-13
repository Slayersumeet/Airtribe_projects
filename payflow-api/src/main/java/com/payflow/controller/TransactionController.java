package com.payflow.controller;

import com.payflow.entity.Transaction;
import com.payflow.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // POST /transactions — transfer money between two users
    @PostMapping
    public ResponseEntity<?> sendMoney(@RequestBody Transaction transaction) {
        try {
            Transaction saved = transactionService.sendMoney(transaction);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET /transactions — see all transactions
    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAllTransactions();
    }

    // GET /transactions/sender/sumeet@okaxis
    @GetMapping("/sender/{upiId}")
    public List<Transaction> getBySender(@PathVariable String upiId) {
        return transactionService.getBySender(upiId);
    }

    // GET /transactions/receiver/priya@okaxis
    @GetMapping("/receiver/{upiId}")
    public List<Transaction> getByReceiver(@PathVariable String upiId) {
        return transactionService.getByReceiver(upiId);
    }
}
