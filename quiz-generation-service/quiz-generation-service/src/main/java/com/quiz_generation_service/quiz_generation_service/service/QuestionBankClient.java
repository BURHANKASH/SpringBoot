package com.quiz_generation_service.quiz_generation_service.service;

import com.quiz_generation_service.quiz_generation_service.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionBankClient {
    @Autowired
    private RestTemplate restTemplate;

//    @Value("${QUESTION_BANK_SERVICE_URL}")
    private final String questionBankServiceUrl = "http://question-bank-service:8080/api/questions";
//    private  final String QUESTION_BANK_SERVICE_URL = "http://localhost:8080/api/questions";

    public List<Question> getQuestions(String subject, String topic, String complexity) {
//        String url = QUESTION_BANK_SERVICE_URL + "?subject=" + subject + "&topic=" + topic + "&complexity=" + complexity;
        String url = questionBankServiceUrl + "?subject=" + subject + "&topic=" + topic + "&complexity=" + complexity;
        Question[] questions = restTemplate.getForObject(url, Question[].class);
        return Arrays.asList(questions);
    }
}
