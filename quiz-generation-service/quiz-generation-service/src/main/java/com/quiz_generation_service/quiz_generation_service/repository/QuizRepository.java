package com.quiz_generation_service.quiz_generation_service.repository;

import com.quiz_generation_service.quiz_generation_service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
