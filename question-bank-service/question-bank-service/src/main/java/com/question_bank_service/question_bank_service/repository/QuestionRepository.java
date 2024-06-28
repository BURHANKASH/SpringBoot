package com.question_bank_service.question_bank_service.repository;

import com.question_bank_service.question_bank_service.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question,String> {
    List<Question> findBySubject(String subject);
    List<Question> findByTopic(String topic);
    List<Question> findByDifficultyLevel(String difficultyLevel);
    List<Question> findBySubjectAndTopic(String subject,String topic);
    List<Question> findBySubjectAndDifficultyLevel(String subject,String difficultyLevel);
    List<Question> findByTopicAndDifficultyLevel(String topic, String difficultyLevel);
    List<Question> findBySubjectAndTopicAndDifficultyLevel(String subject,String topic,String difficultyLevel);

}
