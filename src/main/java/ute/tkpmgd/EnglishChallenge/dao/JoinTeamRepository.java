package ute.tkpmgd.EnglishChallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.JoinTeam;

@Repository
public interface JoinTeamRepository extends JpaRepository<JoinTeam, Integer> {

}
