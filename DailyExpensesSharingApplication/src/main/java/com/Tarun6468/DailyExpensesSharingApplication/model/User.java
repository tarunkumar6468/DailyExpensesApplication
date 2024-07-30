package com.Tarun6468.DailyExpensesSharingApplication.model;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String mobile;
}


