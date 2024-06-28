package com.quiz_generation_service.quiz_generation_service.service;

import com.quiz_generation_service.quiz_generation_service.model.Quiz;
import com.quiz_generation_service.quiz_generation_service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz generateQuiz(String subject, String topic, int numQuestions, String complexity, int durationMinutes) {
        List<String> questionIds = generateRandomQuestionsIds(numQuestions);
        Quiz quiz = new Quiz();
        quiz.setSubject(subject);
        quiz.setTopic(topic);
        quiz.setDurationMinutes(durationMinutes);
        quiz.setComplexity(complexity);
        quiz.setQuestionIds(questionIds);
        return quizRepository.save(quiz);
    }
    private List<String> generateRandomQuestionsIds(int numQuestions){
        List<String> questionIds = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numQuestions; i++) {
            questionIds.add(String.valueOf(random.nextInt(1000))); // Mock random question IDs
        }
        return questionIds;
    }
}
