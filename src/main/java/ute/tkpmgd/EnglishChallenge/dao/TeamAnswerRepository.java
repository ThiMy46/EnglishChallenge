package ute.tkpmgd.EnglishChallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.TeamAnswer;

@Repository
public interface TeamAnswerRepository extends JpaRepository<TeamAnswer, Integer> {

}
