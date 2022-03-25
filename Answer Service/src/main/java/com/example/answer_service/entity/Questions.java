package com.example.answer_service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Questions {

    private int id;
    private String description;
    private String tag;
    private int point;
    private String [] options;


}


