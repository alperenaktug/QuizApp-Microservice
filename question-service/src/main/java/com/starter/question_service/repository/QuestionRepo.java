package com.starter.question_service.repository;

import com.starter.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {

   List<Question> findByCategory(String category);

   @Query (value = "SELECT g.id FROM question WHERE category = :category ORDER BY RANDOM() LIMIT :numQ",
           nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
