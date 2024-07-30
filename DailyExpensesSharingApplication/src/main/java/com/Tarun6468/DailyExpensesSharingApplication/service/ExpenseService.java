package com.Tarun6468.DailyExpensesSharingApplication.service;

import com.Tarun6468.DailyExpensesSharingApplication.model.Expense;
import com.Tarun6468.DailyExpensesSharingApplication.repo.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {
        validateExpense(expense);
        return expenseRepository.save(expense);
    }

    public List<Expense> getUserExpenses(String userId) {
        return expenseRepository.findByParticipant(userId);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    private void validateExpense(Expense expense) {
        String splitMethod = expense.getSplitMethod();
        if (splitMethod == null) {
            throw new IllegalArgumentException("Split method cannot be null");
        }

        switch (splitMethod.toLowerCase()) {
            case "equal":
                validateEqualSplit(expense);
                break;
            case "exact":
                validateExactAmounts(expense);
                break;
            case "percentage":
                validatePercentageAmounts(expense);
                break;
            default:
                throw new IllegalArgumentException("Invalid split method");
        }
    }

    private void validateEqualSplit(Expense expense) {
        // No additional validation required for equal split
    }

    private void validateExactAmounts(Expense expense) {
        double totalAmount = expense.getTotalAmount();
        Map<String, Double> exactAmounts = expense.getExactAmounts();
        double sum = exactAmounts.values().stream().mapToDouble(Double::doubleValue).sum();

        if (sum != totalAmount) {
            throw new IllegalArgumentException("Sum of exact amounts must be equal to the total amount");
        }
    }

    private void validatePercentageAmounts(Expense expense) {
        double totalAmount = expense.getTotalAmount();
        Map<String, Double> percentages = expense.getPercentages();
        double sumPercentages = percentages.values().stream().mapToDouble(Double::doubleValue).sum();

        if (sumPercentages != 100.0) {
            throw new IllegalArgumentException("Sum of percentages must be 100%");
        }

        percentages.forEach((userId, percentage) -> {
            double calculatedAmount = (percentage / 100) * totalAmount;
            expense.getExactAmounts().put(userId, calculatedAmount);
        });
    }
}
