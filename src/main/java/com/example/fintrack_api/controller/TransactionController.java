package com.example.fintrack_api.controller;

import com.example.fintrack_api.entity.Transaction;
import com.example.fintrack_api.service.TransactionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionServiceImpl service;

    public TransactionController(TransactionServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return service.addTransaction(transaction);
    }

    @GetMapping("/getAll")
    public List<Transaction> getAll() {
        return service.getAllTransaction();
    }

    @GetMapping("/get/{id}")
    public Optional<Transaction> getById(@PathVariable Long id){
        return service.getTransactionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
