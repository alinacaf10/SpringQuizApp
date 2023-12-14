package com.example.quizapp.repository;

import com.example.quizapp.domain.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {


    List<Question> getQuestionByCategory(String category);


    @Query(value = "SELECT * from question q where q.category = :category Order by rand() limit :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
