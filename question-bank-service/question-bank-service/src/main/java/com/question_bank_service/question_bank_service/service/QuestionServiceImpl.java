package com.question_bank_service.question_bank_service.service;

import com.question_bank_service.question_bank_service.model.Question;
import com.question_bank_service.question_bank_service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> getQuestionById(String id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(String id, Question question) {
        if(!questionRepository.existsById(id)){
            throw new RuntimeException("Question not found with Id");
        }
        question.setId(id);
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(String id) {

        questionRepository.deleteById(id);

    }

    @Override
    public List<Question> getQuestionBySubject(String subject) {
        return questionRepository.findBySubject(subject);
    }

    @Override
    public List<Question> getQuestionByTopic(String topic) {
        return questionRepository.findByTopic(topic);
    }

    @Override
    public List<Question> getQuestionByDifficultyLevel(String difficultyLevel) {
        return questionRepository.findByDifficultyLevel(difficultyLevel);
    }

    @Override
    public List<Question> getQuestionBySubjectAndTopic(String subject, String topic) {
        return questionRepository.findBySubjectAndTopic(subject, topic);
    }

    @Override
    public List<Question> getQuestionBySubjectAndDifficultyLevel(String subject, String difficultyLevel) {
        return questionRepository.findBySubjectAndDifficultyLevel(subject, difficultyLevel);
    }

    @Override
    public List<Question> getQuestionByTopicAndDifficultyLevel(String topic, String difficultyLevel) {
        return questionRepository.findByTopicAndDifficultyLevel(topic, difficultyLevel);
    }

    @Override
    public List<Question> getQuestionBySubjectAndTopicAndDifficultyLevel(String subject, String topic, String difficultyLevel) {
        return questionRepository.findBySubjectAndTopicAndDifficultyLevel(subject, topic, difficultyLevel);
    }
}
