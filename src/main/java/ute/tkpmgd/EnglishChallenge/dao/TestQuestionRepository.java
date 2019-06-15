package ute.tkpmgd.EnglishChallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.TestQuestion;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion, Integer>{

}
