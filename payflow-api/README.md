# 💸 PayFlow API

A UPI-style payment REST API built with **Spring Boot + H2 + JPA**.
Built by **Sumeet**.

---

## 🚀 How to Run

### Prerequisites
- Java 17+
- Maven 3.8+

### Start the server
```bash
mvn spring-boot:run
```
Server starts at: `http://localhost:8080`
H2 Database Console: `http://localhost:8080/h2-console`

---

## 📡 API Endpoints

### Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/users` | Register a new user |
| GET | `/users` | Get all users |
| GET | `/users/{id}` | Get user by ID |
| GET | `/users/upi/{upiId}` | Get user by UPI ID |
| GET | `/users/balance/{amount}` | Users with balance above amount |

### Transactions
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/transactions` | Send money between users |
| GET | `/transactions` | Get all transactions |
| GET | `/transactions/sender/{upiId}` | Transactions sent by user |
| GET | `/transactions/receiver/{upiId}` | Transactions received by user |

---

## 🧪 Sample curl Commands

```bash
# Register users
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Sumeet","upiId":"sumeet@okaxis","phoneNumber":"9876543200","balance":10000}'

curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Priya","upiId":"priya@okaxis","phoneNumber":"9876543210","balance":5000}'

curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Rahul","upiId":"rahul@okhdfc","phoneNumber":"9876543222","balance":3000}'

# Get all users
curl http://localhost:8080/users

# Send money
curl -X POST http://localhost:8080/transactions \
  -H "Content-Type: application/json" \
  -d '{"senderUpiId":"sumeet@okaxis","receiverUpiId":"priya@okaxis","amount":2000}'

# View all transactions
curl http://localhost:8080/transactions

# Transactions sent by Sumeet
curl http://localhost:8080/transactions/sender/sumeet@okaxis

# Users with balance above 4000
curl http://localhost:8080/users/balance/4000
```

---

## 🔧 What Was Fixed & Improved

| Issue | Fix |
|-------|-----|
| `@Entity` class named `User` clashes with SQL reserved word | Added `@Table(name = "users")` |
| No `@Param` annotation on custom query | Added `@Param("amount")` in `UserRepository` |
| `sendMoney` had no validation — could send negative amounts or to non-existent users | Added full validation in `TransactionService` |
| Balance was never actually deducted | `TransactionService` now deducts sender and credits receiver |
| No `@Transactional` on money transfer | Added `@Transactional` for atomicity |
| No error handling in controller | `TransactionController` returns `400 Bad Request` with message |
| Transaction had no timestamp or status | Added `createdAt` and `status` fields |

---

## 🏗️ Project Structure

```
payflow-api/
├── src/main/java/com/payflow/
│   ├── PayflowApplication.java       ← Entry point
│   ├── entity/
│   │   ├── User.java                 ← Database table: users
│   │   └── Transaction.java          ← Database table: transactions
│   ├── repository/
│   │   ├── UserRepository.java       ← DB queries for users
│   │   └── TransactionRepository.java
│   ├── service/
│   │   ├── UserService.java          ← Business logic
│   │   └── TransactionService.java   ← Money transfer logic
│   └── controller/
│       ├── UserController.java       ← REST endpoints for /users
│       └── TransactionController.java← REST endpoints for /transactions
└── src/main/resources/
    └── application.properties        ← DB + JPA config
```
