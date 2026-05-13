package com.example.fintrack_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double amount;
    private String type;
    private String category;
    private LocalDate transactionDate;
    private String description;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", transaction_date=" + transactionDate +
                ", description='" + description + '\'' +
                ", created_at=" + createdAt +
                '}';
    }
}
