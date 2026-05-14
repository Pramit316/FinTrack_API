package com.example.fintrack_api.service.service_interface;

import com.example.fintrack_api.enums.TransactionType;

import java.util.Date;
import java.util.Map;

public interface ReportService {
    Map<String, Double> getSummary();
    Map<String, Double> expenseSummary();
    Map<String, Double> incomeSummary();
    Map<String, Double> monthlySummary(Date date);
    Map<String, Double> filterByType(TransactionType type);
    Map<String, Double> filterByCategory(String category);
    Map<String, Double> filterByDateRange(Date d1, Date d2);
}
