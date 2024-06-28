package com.question_bank_service.question_bank_service.service;

import com.question_bank_service.question_bank_service.model.Question;
import com.question_bank_service.question_bank_service.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class QuestionServiceTest {
    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    private Question question;

    @BeforeEach
    void  setUp(){
       MockitoAnnotations.openMocks(this);
        question = Question.builder()
                .id("q1")
                .subject("Math")
                .topic("Algebra")
                .questionText("What is 2+2?")
                .options(List.of("4"))
                .difficultyLevel("easy")
                .build();
    }
    @Test
    void testCreateQuestion(){
        when(questionRepository.save(any(Question.class))).thenReturn(question);
        Question createdQuestion = questionService.createQuestion(question);
        assertNotNull(createdQuestion);
        assertEquals(question.getId(),createdQuestion.getId());
    }
    @Test
    void GetQuestionById(){
        when(questionRepository.findById("q1")).thenReturn(Optional.of(question));
        Optional<Question> fetchedQuestion = questionService.getQuestionById("q1");
        assertTrue(fetchedQuestion.isPresent());
        assertEquals(question.getId(),fetchedQuestion.get().getId());
    }

    @Test
    void testAllQuestions(){
        when(questionRepository.findAll()).thenReturn(List.of(question));
        List<Question> questions = questionService.getAllQuestions();
        assertFalse(questions.isEmpty());
        assertEquals(1,questions.size());

    }
    @Test
    void testUpdateQuestion(){
        when(questionRepository.existsById("q1")).thenReturn(true);
        when(questionRepository.findById("q1")).thenReturn(Optional.of(question));
        when(questionRepository.save(any(Question.class))).thenReturn(question);
        Question updatedQuestion = questionService.updateQuestion("q1",question);
        assertNotNull(updatedQuestion);
        assertEquals(question.getId(),updatedQuestion.getId());
    }
    @Test
    void testDeleteQuestion(){
        doNothing().when(questionRepository).deleteById("q1");
        questionService.deleteQuestion("q1");
        verify(questionRepository,times(1)).deleteById("q1");
    }

}
