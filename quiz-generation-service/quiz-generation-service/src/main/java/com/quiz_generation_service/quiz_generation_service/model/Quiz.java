package com.quiz_generation_service.quiz_generation_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String topic;
    private int durationMinutes;
    private String complexity;
    @ElementCollection
    private List<String> questionIds;

}
