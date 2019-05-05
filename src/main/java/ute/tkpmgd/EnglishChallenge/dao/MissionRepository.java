package ute.tkpmgd.EnglishChallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer> {

}
