package com.Tarun6468.DailyExpensesSharingApplication.repo;

import com.Tarun6468.DailyExpensesSharingApplication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}



