package com.example.quizapp.service;

import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.domain.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {

        return new ResponseEntity<>(questionRepository.getQuestionByCategory(category), HttpStatus.OK);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepository.save(question);

        return new ResponseEntity<>("Successfully Added", HttpStatus.CREATED);

    }

    public ResponseEntity<String> deleteById(Integer id) {
        questionRepository.deleteById(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }
}
