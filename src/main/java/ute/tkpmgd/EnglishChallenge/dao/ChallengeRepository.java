package ute.tkpmgd.EnglishChallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {

}
