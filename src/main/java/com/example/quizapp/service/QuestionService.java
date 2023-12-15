package com.example.quizapp.service;

import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.domain.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return (questionRepository.findAll());
    }

    public List<Question> getQuestionByCategory(String category) {

        return (questionRepository.getQuestionByCategory(category));

    }

    public String addQuestion(Question question) {
        questionRepository.save(question);

        return ("Successfully Added");

    }

    public String deleteById(Integer id) {
        questionRepository.deleteById(id);
        return ("Successfully Deleted");
    }
}
