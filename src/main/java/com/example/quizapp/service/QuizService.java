package com.example.quizapp.service;

import com.example.quizapp.exception.QuizNotFoundException;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.domain.entity.Question;
import com.example.quizapp.domain.model.QuestionWrapper;
import com.example.quizapp.domain.entity.Quiz;
import com.example.quizapp.domain.model.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    public String createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return "Success";
    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Quiz quiz=quizRepository.findById(id).orElseThrow(()->new QuizNotFoundException("Quiz with "+id+" not found"));
        List<Question> questionsFromDB = quiz.getQuestions();
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();

        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUsers.add(qw);
        }
        return (questionsForUsers);
    }

    public Integer calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getAnswer()))
                right++;

            i++;
        }
        return right;
    }
}
