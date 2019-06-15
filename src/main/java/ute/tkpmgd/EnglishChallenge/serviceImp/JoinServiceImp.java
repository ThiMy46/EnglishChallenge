package ute.tkpmgd.EnglishChallenge.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.tkpmgd.EnglishChallenge.dao.JoinRepository;
import ute.tkpmgd.EnglishChallenge.exception.NotFoundException;
import ute.tkpmgd.EnglishChallenge.model.Join;
import ute.tkpmgd.EnglishChallenge.service.IJoinService;

@Service
public class JoinServiceImp implements IJoinService{

	@Autowired
	JoinRepository joinRe;
	
	@Override
	public Join getJoinById(int id) {
		return joinRe.findById(id)
				.orElseThrow(() -> new NotFoundException());
	}

	@Override
	public Join createJoin(Join join) {
		return joinRe.save(join);
	}

}
