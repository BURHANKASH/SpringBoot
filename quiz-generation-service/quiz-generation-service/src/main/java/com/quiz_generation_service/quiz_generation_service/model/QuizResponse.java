package com.quiz_generation_service.quiz_generation_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {
    private Long id;
    private String subject;
    private String topic;
    private int durationMinutes;
    private String complexity;
    private List<Question> questions;

    public QuizResponse(Quiz quiz, List<Question> questions) {
        this.id = quiz.getId();
        this.subject = quiz.getSubject();
        this.topic = quiz.getTopic();
        this.durationMinutes = quiz.getDurationMinutes();
        this.complexity = quiz.getComplexity();
        this.questions = questions;
    }
}

