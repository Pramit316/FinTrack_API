package com.example.fintrack_api.service.service_interface;

import com.example.fintrack_api.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
    Optional<Transaction> getTransactionById(Long Id);
    Transaction updateTransaction(Transaction transaction, Long Id);
    void delete(Long Id);
}
