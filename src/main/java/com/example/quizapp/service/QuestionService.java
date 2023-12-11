package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionDao;
import com.example.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
    return questionDao.findAll();
    }
    public List<Question> getQuestionByCategory(String category){
        return questionDao.getQuestionByCategory(category);
    }

    public List<Question> getQuestionByDifficulty(String difficulty) {
        return questionDao.getQuestionByDifficultyLevel(difficulty);
    }

    public String addQuestion(Question question) {
         questionDao.save(question);
         return "Successfully Added";
    }

    public String deleteById(Long id) {
        questionDao.deleteById(id.intValue());
        return "Successfully Deleted";
    }
}
