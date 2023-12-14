package com.example.quizapp.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private enum questionLevel{
        EASY, MEDIUM,HARD
    };
    private String answer;
    private String category;
}

