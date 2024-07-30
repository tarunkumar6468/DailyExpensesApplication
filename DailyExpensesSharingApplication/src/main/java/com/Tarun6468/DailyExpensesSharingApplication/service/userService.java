package com.Tarun6468.DailyExpensesSharingApplication.service;



import com.Tarun6468.DailyExpensesSharingApplication.model.User;
import com.Tarun6468.DailyExpensesSharingApplication.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}

