package com.example.inventory_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class QuestionStatus {

    private Questions question;
    private String status;
    private String message;
}