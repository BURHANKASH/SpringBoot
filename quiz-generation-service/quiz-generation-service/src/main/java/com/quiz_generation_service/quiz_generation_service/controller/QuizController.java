package com.quiz_generation_service.quiz_generation_service.controller;

import com.quiz_generation_service.quiz_generation_service.model.Question;
import com.quiz_generation_service.quiz_generation_service.model.Quiz;
import com.quiz_generation_service.quiz_generation_service.model.QuizResponse;
import com.quiz_generation_service.quiz_generation_service.repository.QuizRepository;
import com.quiz_generation_service.quiz_generation_service.service.QuestionBankClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuestionBankClient questionBankClient;
    @Autowired
    private QuizRepository quizRepository;

    @PostMapping("/generate")
    public QuizResponse generateQuiz(@RequestParam String subject,
                                     @RequestParam String topic,
                                     @RequestParam int numQuestions,
                                     @RequestParam String complexity,
                                     @RequestParam int durationMinutes) {
        List<Question> questions = questionBankClient.getQuestions(subject, topic, complexity);
        List<Question> filteredQuestions = questions.stream()
                .filter(q -> q.getDifficultyLevel().equalsIgnoreCase(complexity))
                .filter(q -> q.getSubject().equalsIgnoreCase(subject))
                .filter(q -> q.getTopic().equalsIgnoreCase(topic))
                .collect(Collectors.toList());

        if (filteredQuestions.size() > numQuestions) {
            Collections.shuffle(filteredQuestions);
            filteredQuestions = filteredQuestions.subList(0, numQuestions);
        }
        List<String> questionIds = filteredQuestions.stream()
                .map(Question::getId)
                .collect(Collectors.toList());

        Quiz quiz = new Quiz();
        quiz.setSubject(subject);
        quiz.setTopic(topic);
        quiz.setDurationMinutes(durationMinutes);
        quiz.setComplexity(complexity);
        quiz.setQuestionIds(questionIds);
        Quiz savedQuiz =  quizRepository.save(quiz);
        return new QuizResponse(savedQuiz, questions);

    }
}
