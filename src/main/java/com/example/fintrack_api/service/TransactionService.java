package com.example.fintrack_api.service;

import com.example.fintrack_api.entity.Transaction;
import com.example.fintrack_api.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }


    public Transaction addTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransaction(){
        return repository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id){
        return repository.findById(id);
    }

    public Transaction updateTransaction(Transaction transaction, Long id){
        Optional<Transaction> t1 = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found")));
        t1.get().setAmount(transaction.getAmount());
        t1.get().setTitle(transaction.getTitle());
        t1.get().setCategory(transaction.getCategory());
        t1.get().setType(transaction.getType());
        t1.get().setDescription(transaction.getDescription());

        return repository.save(transaction);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
