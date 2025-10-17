package com.starter.quiz_service.controller;


import com.starter.quiz_service.model.QuestionWrapper;
import com.starter.quiz_service.model.QuizDto;
import com.starter.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(),
                                      quizDto.getNumQuestions(),
                                      quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
}
