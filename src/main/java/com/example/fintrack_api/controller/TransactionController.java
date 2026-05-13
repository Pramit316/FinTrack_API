package com.example.fintrack_api.controller;

import com.example.fintrack_api.entity.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return
    }
}
