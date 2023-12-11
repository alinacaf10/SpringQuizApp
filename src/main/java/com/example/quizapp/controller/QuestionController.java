package com.example.quizapp.controller;

import com.example.quizapp.entity.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @GetMapping("/difficulty/{difficulty}")
    public List<Question> getQuestionByDifficulty(@PathVariable String difficulty) {
        return questionService.getQuestionByDifficulty(difficulty);
    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id){
        return questionService.deleteById(id);
    }
}
