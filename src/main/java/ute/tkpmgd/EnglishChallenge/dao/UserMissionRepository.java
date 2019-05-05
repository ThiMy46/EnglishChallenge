package ute.tkpmgd.EnglishChallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.UserMission;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Integer> {

}
