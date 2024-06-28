package com.question_bank_service.question_bank_service.service;

import com.question_bank_service.question_bank_service.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> getAllQuestions();
    Optional<Question> getQuestionById(String id);
    Question createQuestion(Question question);
    Question updateQuestion(String id, Question question);
    void deleteQuestion(String id);
    List<Question> getQuestionBySubject(String subject);
    List<Question> getQuestionByTopic(String topic);
    List<Question> getQuestionByDifficultyLevel(String difficultyLevel);
    List<Question> getQuestionBySubjectAndTopic(String subject,String topic);
    List<Question> getQuestionBySubjectAndDifficultyLevel(String subject,String difficultyLevel);
    List<Question> getQuestionByTopicAndDifficultyLevel(String topic, String difficultyLevel);
    List<Question> getQuestionBySubjectAndTopicAndDifficultyLevel(String subject,String topic, String difficultyLevel);

}
