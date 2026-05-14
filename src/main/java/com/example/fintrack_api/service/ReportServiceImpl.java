package com.example.fintrack_api.service;

import com.example.fintrack_api.entity.Transaction;
import com.example.fintrack_api.enums.TransactionType;
import com.example.fintrack_api.repository.TransactionRepository;
import com.example.fintrack_api.service.service_interface.ReportService;
import com.example.fintrack_api.service.service_interface.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    TransactionRepository transactionRepository;

    TransactionService transactionService;

    public ReportServiceImpl(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @Override
    public Map<String, Double> getSummary() {
        List<Transaction> transaction = transactionService.getAllTransaction();
        double balance = 0;

        //todo this is the way we typically do but we can also use stream. It looks complicated but idk
//        for(Transaction t: transaction){
//            try{
//                if(t.getType().equalsIgnoreCase("expense")){
//                    expense += t.getAmount();
//                } else if (t.getType().equalsIgnoreCase("income")) {
//                    income += t.getAmount();
//                }
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }

        double income = transaction.stream()
                .filter(t -> t.getType() != null)
                .filter(t -> t.getType().equalsIgnoreCase("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();


        double expense = transaction.stream()
                .filter(t-> t.getType() !=null)
                .filter(t-> t.getType().equalsIgnoreCase("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        balance = income - expense;
        Map<String, Double> summary= new HashMap<>();
        summary.put("Balance", balance);
        summary.put("Income", income);
        summary.put("Expense", expense);
        return summary;
    }

    @Override
    public Map<String, Double> expenseSummary() {
        List<Transaction> transaction = transactionService.getAllTransaction();
        double expense = transaction.stream()
                .filter(t-> t.getType() != null)
                .filter(t-> t.getType().equalsIgnoreCase("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        return Map.of("expense", expense);
    }

    @Override
    public Map<String, Double> incomeSummary() {
        List<Transaction> transaction = transactionService.getAllTransaction();
        double income = transaction.stream()
                .filter(t-> t.getType() != null)
                .filter(t-> t.getType().equalsIgnoreCase("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        return Map.of("income", income);
    }

    @Override
    public Map<String, Double> monthlySummary(int month, int year) {
        List<Transaction> transactions = transactionService.getAllTransaction();
        double income = transactions.stream()
                .filter(t -> t.getTransactionDate() != null)
                .filter(t -> t.getTransactionDate().getMonthValue() == month)
                .filter(t -> t.getTransactionDate().getYear() == year)
                .filter(t-> t.getType().equalsIgnoreCase("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double expense = transactions.stream()
                .filter(t -> t.getTransactionDate() != null)
                .filter(t -> t.getTransactionDate().getMonthValue() == month)
                .filter(t -> t.getTransactionDate().getYear() == year)
                .filter(t-> t.getType().equalsIgnoreCase("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double balance = income - expense;
        Map<String, Double> summary = new HashMap<>();
        summary.put("Income", income);
        summary.put("Expense", expense);
        summary.put("Balance", balance   );
        return summary;
    }

    @Override
    public Map<String, Double> filterByType(TransactionType type) {
        return Map.of();
    }

    @Override
    public Map<String, Double> filterByCategory(String category) {
        return Map.of();
    }

    @Override
    public Map<String, Double> filterByDateRange(Date d1, Date d2) {
        return Map.of();
    }
}
