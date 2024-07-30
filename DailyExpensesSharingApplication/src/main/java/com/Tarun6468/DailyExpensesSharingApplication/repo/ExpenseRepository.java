package com.Tarun6468.DailyExpensesSharingApplication.repo;
import java.util.List;

import com.Tarun6468.DailyExpensesSharingApplication.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{ 'participants': ?0 }")
    List<Expense> findByParticipant(String userId);
}

