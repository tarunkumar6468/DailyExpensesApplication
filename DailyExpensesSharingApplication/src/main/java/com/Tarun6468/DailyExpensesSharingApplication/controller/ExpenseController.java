package com.Tarun6468.DailyExpensesSharingApplication.controller;




import com.Tarun6468.DailyExpensesSharingApplication.model.Expense;
import com.Tarun6468.DailyExpensesSharingApplication.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense addExpense( @Valid @RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getUserExpenses(@PathVariable String userId) {
        return expenseService.getUserExpenses(userId);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
}


