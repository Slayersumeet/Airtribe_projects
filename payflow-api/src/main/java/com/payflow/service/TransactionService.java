package com.payflow.service;

import com.payflow.entity.Transaction;
import com.payflow.entity.User;
import com.payflow.repository.TransactionRepository;
import com.payflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * @Transactional = "all or nothing"
     * If balance deduction succeeds but saving fails, everything rolls back.
     * This is called atomicity — a core database concept.
     */
    @Transactional
    public Transaction sendMoney(Transaction transaction) {
        User sender   = userRepository.findByUpiId(transaction.getSenderUpiId());
        User receiver = userRepository.findByUpiId(transaction.getReceiverUpiId());

        if (sender == null)
            throw new RuntimeException("Sender not found: " + transaction.getSenderUpiId());
        if (receiver == null)
            throw new RuntimeException("Receiver not found: " + transaction.getReceiverUpiId());
        if (transaction.getAmount() <= 0)
            throw new RuntimeException("Amount must be greater than zero.");
        if (sender.getBalance() < transaction.getAmount())
            throw new RuntimeException("Insufficient balance. Available: " + sender.getBalance());

        sender.setBalance(sender.getBalance() - transaction.getAmount());
        receiver.setBalance(receiver.getBalance() + transaction.getAmount());

        userRepository.save(sender);
        userRepository.save(receiver);

        transaction.setStatus("SUCCESS");
        transaction.setCreatedAt(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions()                     { return transactionRepository.findAll(); }
    public List<Transaction> getBySender(String upiId)               { return transactionRepository.findBySenderUpiId(upiId); }
    public List<Transaction> getByReceiver(String upiId)             { return transactionRepository.findByReceiverUpiId(upiId); }
}
