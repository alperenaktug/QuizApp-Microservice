package com.starter.question_service.controller;



import com.starter.question_service.model.Question;
import com.starter.question_service.model.QuestionWrapper;
import com.starter.question_service.model.Response;
import com.starter.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "question")
public class QuestionController {


    @Autowired
    private QuestionService questionService;


    @GetMapping(path = "allQuestions")
    public ResponseEntity<List<Question>>    getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping(path = "category/{category}")
    public ResponseEntity<List<Question>>  getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);

    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>>  getQuestionsForQuiz
            (@RequestParam String categoryName , @RequestParam Integer numQuestions){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsFromId(questionIds);

    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore (@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
