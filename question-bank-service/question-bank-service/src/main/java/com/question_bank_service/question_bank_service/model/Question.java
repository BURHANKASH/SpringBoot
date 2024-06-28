package com.question_bank_service.question_bank_service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "question")
public class Question {
    @Id
    private String id ;
    private String subject;
    private String topic;
    private String questionText;
    private List<String> options;
    private List<String> correctAnswers;
//    private String evaluationStrategy;//newly added
    private String difficultyLevel;
//    private String type;//newly added
}
