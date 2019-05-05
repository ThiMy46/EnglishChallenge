package ute.tkpmgd.EnglishChallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.ChallengeQuestion;

@Repository
public interface ChallengeQuestionRepository extends JpaRepository<ChallengeQuestion, Integer> {

}
