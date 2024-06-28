package com.question_bank_service.question_bank_service.controller;

import com.question_bank_service.question_bank_service.model.Question;
import com.question_bank_service.question_bank_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping
    public List<Question> getAllQuestions(@RequestParam(required = false) String subject,
                                          @RequestParam(required = false) String topic,
                                          @RequestParam(required = false) String complexity) {
        if (subject != null && topic != null && complexity != null) {
            return questionService.getQuestionBySubjectAndTopicAndDifficultyLevel(subject, topic, complexity);
        } else if (subject != null && topic != null) {
            return questionService.getQuestionBySubjectAndTopic(subject, topic);
        } else if (subject != null && complexity != null) {
            return questionService.getQuestionBySubjectAndDifficultyLevel(subject, complexity);
        } else if (topic != null && complexity != null) {
            return questionService.getQuestionByTopicAndDifficultyLevel(topic, complexity);
        } else if (subject != null) {
            return questionService.getQuestionBySubject(subject);
        } else if (topic != null) {
            return questionService.getQuestionByTopic(topic);
        } else if (complexity != null) {
            return questionService.getQuestionByDifficultyLevel(complexity);
        } else {
            return questionService.getAllQuestions();
        }
    }
    @GetMapping("/{id}")
    public Optional<Question> getQuestionById(@PathVariable String id){
        return  questionService.getQuestionById(id);
    }
    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }
    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable String id ,@RequestBody Question question ){
        return questionService.updateQuestion(id,question);
    }
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable String id){
        questionService.deleteQuestion(id);
    }
}
