package com.quiz_generation_service.quiz_generation_service.service;

import com.quiz_generation_service.quiz_generation_service.model.Quiz;

import javax.security.auth.Subject;

public interface QuizService {
    Quiz generateQuiz(String subject,String topic,
        int numQuestions,String complexity,int durationMinutes);
}
