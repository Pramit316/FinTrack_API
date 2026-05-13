package com.example.fintrack_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    private Long id;
    private String title;
    private double amount;
    private String type;
    private String category;
    private LocalDate transaction_date;
    private String description;
    private LocalDateTime created_at;
}
