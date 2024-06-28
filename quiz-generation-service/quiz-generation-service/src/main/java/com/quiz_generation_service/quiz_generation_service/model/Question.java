package com.quiz_generation_service.quiz_generation_service.model;

import lombok.Data;

import java.util.List;

@Data
public class Question {

    private String id;
    private String subject;
    private String topic;
    private String questionText;
    private List<String> options;
    private List<String> correctAnswers;//static
    private String evaluationStrategy;//dynamic
    private String difficultyLevel;
    private String type;//static or dynamic
}
