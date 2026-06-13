package com.payflow.service;

import com.payflow.entity.User;
import com.payflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user)             { return userRepository.save(user); }
    public List<User> getAllUsers()                  { return userRepository.findAll(); }
    public User getUserById(Long id)                { return userRepository.findById(id).orElse(null); }
    public User findByUpiId(String upiId)           { return userRepository.findByUpiId(upiId); }
    public List<User> getUsersAboveBalance(Double a) { return userRepository.findUsersWithBalanceGreaterThan(a); }
}
