package ute.tkpmgd.EnglishChallenge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.Join;

@Repository
public interface JoinRepository extends JpaRepository<Join, Integer>{

	@Query(value="select * from joins where user2 = 0", nativeQuery=true)
	public List<Join> findJoinEmpty();
}
