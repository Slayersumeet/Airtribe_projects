package com.payflow.repository;

import com.payflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Spring auto-generates SQL from method name: SELECT * FROM users WHERE upi_id = ?
    User findByUpiId(String upiId);

    // @Param("amount") binds the Java variable to :amount in the JPQL query
    @Query("SELECT u FROM User u WHERE u.balance > :amount")
    List<User> findUsersWithBalanceGreaterThan(@Param("amount") Double amount);
}
