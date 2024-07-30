package com.Tarun6468.DailyExpensesSharingApplication.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;
    @NotBlank
    private String description;
    @Positive
    private double totalAmount;
    @NotBlank
    private String splitMethod;
    @NotNull
    private List<String> participants;
    private Map<String, Double> exactAmounts;
    private Map<String, Double> percentages;



    public String getSplitMethod() {
        return this.splitMethod;
    }


    public double getTotalAmount() {
        return this.totalAmount;
    }


    public Map<String, Double> getExactAmounts() {
        return this.exactAmounts;
    }


    public Map<String, Double> getPercentages() {
        return this.percentages;
    }
}

