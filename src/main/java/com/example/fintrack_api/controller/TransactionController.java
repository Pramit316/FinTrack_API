package com.example.fintrack_api.controller;

import com.example.fintrack_api.entity.Transaction;
import com.example.fintrack_api.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction){
        System.out.println(transaction);
        return service.addTransaction(transaction);
    }

    @GetMapping("/getAll")
    public List<Transaction> getAll() {
        return service.getAllTransaction();
    }

    @GetMapping("/get/{id}")
    public Optional<Transaction> getById(@RequestParam Long id){
        return service.getTransactionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@RequestParam Long id){
        service.delete(id);
    }
}
