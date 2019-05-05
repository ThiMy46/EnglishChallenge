package ute.tkpmgd.EnglishChallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ute.tkpmgd.EnglishChallenge.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
