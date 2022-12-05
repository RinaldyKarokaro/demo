package com.simas.demo.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class User {
    @Id
    private String id;
    @NotNull
    private String nama;
    @Min(10)
    @Max(20)
    private int umur;
    @Email
    private String email;
    private String phone;
}
