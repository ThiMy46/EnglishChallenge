package ute.tkpmgd.EnglishChallenge.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.tkpmgd.EnglishChallenge.dao.ChallengeRepository;
import ute.tkpmgd.EnglishChallenge.exception.NotFoundException;
import ute.tkpmgd.EnglishChallenge.model.Challenge;
import ute.tkpmgd.EnglishChallenge.service.ChallengeService;

@Service
public class ChallengeServiceImp implements ChallengeService{

	@Autowired
	ChallengeRepository challengeRepository;
	
	@Override
	public Challenge getChallengeById(int id) {
		return challengeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
	}

}
